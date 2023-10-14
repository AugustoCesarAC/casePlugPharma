package com.demonstration.cadastroPessoaJuridica.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.demonstration.cadastroPessoaJuridica.model.PessoaFisicaModel;
import com.demonstration.cadastroPessoaJuridica.repository.PessoaFisicaRepository;
import com.demonstration.cadastroPessoaJuridica.service.PessoaFisicaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoafisica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private PessoaFisicaService pessoaFisicaService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/list")
	public ResponseEntity<List<PessoaFisicaModel>> getAll(){
		return ResponseEntity.ok(pessoaFisicaRepository.findAll());
	}
	
	@PostMapping("/new")
	public ResponseEntity<PessoaFisicaModel> postPessoaFisica(@Valid @RequestBody PessoaFisicaModel pessoaFisicaModel) throws JsonMappingException, JsonProcessingException{
		
		if(pessoaFisicaModel.getCep().matches("[0-9]{8}$")) {
		String apiUrl = "https://viacep.com.br/ws/" + pessoaFisicaModel.getCep() + "/json";
        String jsonResponse = restTemplate.getForObject(apiUrl, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        PessoaFisicaModel enderecoModel = objectMapper.readValue(jsonResponse, PessoaFisicaModel.class);
        
        pessoaFisicaModel.setLogradouro(enderecoModel.getLogradouro());
        pessoaFisicaModel.setComplemento(enderecoModel.getComplemento());
        pessoaFisicaModel.setBairro(enderecoModel.getBairro());
        pessoaFisicaModel.setLocalidade(enderecoModel.getLocalidade());
        pessoaFisicaModel.setUf(enderecoModel.getUf());
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário informar um CEP contendo 8 dígitos");
		}
	   
        return pessoaFisicaService.cadastroPessoaFisica(pessoaFisicaModel)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());  
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PessoaFisicaModel> deletePessoaFisica(@PathVariable UUID id){
		
		if(pessoaFisicaRepository.existsById(id)) {
			pessoaFisicaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
