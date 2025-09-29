package br.com.hessel.controle_financeiro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hessel.controle_financeiro.entities.GrupoEntity;
import br.com.hessel.controle_financeiro.services.CrudGrupoService;

@RestController
@RequestMapping(value = "/api/grupos")
public class GrupoController {
	
	@Autowired
	private CrudGrupoService grupoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<GrupoEntity> listaGrupos(){
		return grupoService.listaGrupos();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public GrupoEntity grupoPorId(@PathVariable("id") Integer id ){		
		return grupoService.listaGrupoPorId(id);
	}
	
	@PostMapping(value = "/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarGrupo(@RequestBody GrupoEntity grupo ){
		 grupoService.salvaGrupo(grupo);
	}
	
	@PutMapping(value = "/{id}/edita")	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editarGrupo(@RequestBody GrupoEntity grupo,@PathVariable("id") Integer id ){
		 grupoService.alteraGrupo(grupo, id);
	}
	@DeleteMapping("/{id}/exclui")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirGrupo(@PathVariable("id") Integer id ){		
		grupoService.excluiGrupo(id);
	}
}
