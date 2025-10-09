package br.com.hessel.controle_financeiro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hessel.controle_financeiro.model.entities.MetaEntity;
import br.com.hessel.controle_financeiro.repositories.MetaRepository;

@RestController
@RequestMapping(value = "/api/testes")
public class TestesGerais {

	@Autowired
	private MetaRepository repo;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MetaEntity> listaGrupos(){
		return repo.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MetaEntity grupoPorId(@PathVariable("id") Integer id ){
		return repo.findById(id).orElse(null);
	}


}
