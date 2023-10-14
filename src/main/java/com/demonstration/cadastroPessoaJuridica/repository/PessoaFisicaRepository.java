package com.demonstration.cadastroPessoaJuridica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demonstration.cadastroPessoaJuridica.model.PessoaFisicaModel;


@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisicaModel, UUID>{

	
}
