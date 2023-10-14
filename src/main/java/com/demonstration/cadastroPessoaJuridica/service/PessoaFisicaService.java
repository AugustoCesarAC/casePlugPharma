package com.demonstration.cadastroPessoaJuridica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demonstration.cadastroPessoaJuridica.model.PessoaFisicaModel;
import com.demonstration.cadastroPessoaJuridica.repository.PessoaFisicaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	public Optional<PessoaFisicaModel> cadastroPessoaFisica(PessoaFisicaModel pessoaFisicaModal){
		
		if(pessoaFisicaModal.getCep() == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário informar um CEP e contendo 8 dígitos");
		
		return Optional.of(pessoaFisicaRepository.save(pessoaFisicaModal));
	}
	
}
