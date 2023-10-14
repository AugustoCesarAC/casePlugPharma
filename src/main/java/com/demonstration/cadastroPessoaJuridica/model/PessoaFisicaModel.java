package com.demonstration.cadastroPessoaJuridica.model;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Entity
@Table (name = "tb_pessoaFisica")
public class PessoaFisicaModel {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotBlank (message = "Necessário colocar o nome completo")
	@Size(min = 5, max = 70)
	private String nomeCompleto;
	
	@CPF (message = "Número de CPF inválido, coloque apenas números ou siga o padrão 111.111.111-11")
	private String cpf;
	
	@NotBlank
	@Size(min = 8, max = 8, message = "Tamanho deve ser conter apenas 8 números")
	private String cep;
	
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    
    public PessoaFisicaModel() {
    	
    }

	public PessoaFisicaModel(String cep, String logradouro, String complemento, String bairro, String localidade,
			String uf, String ibge, String gia, String ddd, String siafi) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
		this.ddd = ddd;
		this.siafi = siafi;
	}
    
    
	
}