package br.com.hessel.controle_financeiro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hessel.controle_financeiro.model.entities.ConfiguracoesEntity;
import br.com.hessel.controle_financeiro.model.entities.LancamentoEntity;
import br.com.hessel.controle_financeiro.model.entities.MetaEntity;
import br.com.hessel.controle_financeiro.model.entities.MovimentoEntity;
import br.com.hessel.controle_financeiro.repositories.ConfiguracoesRepository;
import br.com.hessel.controle_financeiro.repositories.LancamentoRepository;
import br.com.hessel.controle_financeiro.repositories.MetaRepository;
import br.com.hessel.controle_financeiro.repositories.MovimentoRepository;

@RestController
@RequestMapping(value = "/api/testes")
public class TestesGerais {

	@Autowired
	private MetaRepository repo;
	
	@Autowired
	private ConfiguracoesRepository repoConfig;
	@Autowired
	private MovimentoRepository repoMovi;
	@Autowired
	private LancamentoRepository repoLance;
	@Autowired
	private MetaRepository repoMeta;
	
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

	@GetMapping("/configuracao")
	@ResponseStatus(HttpStatus.OK)
	public List<ConfiguracoesEntity> listarConfiguracoes( ){
		return repoConfig.findAll();
	}
	@PostMapping("/configuracao")
	public ConfiguracoesEntity novaConfig(@RequestBody ConfiguracoesEntity config) {
		MetaEntity meta = repo.findById(config.getMeta().getId()).orElse(null);
		if(meta!=null) {
			config.adicionarMeta(meta);
			return repoConfig.save(config);		
		}
		return null;
	}
	@PostMapping("/movimento")
	public MovimentoEntity novoMovimento(@RequestBody MovimentoEntity movimento ) {
		return repoMovi.save(movimento);
	}
	@GetMapping("/movimento")
	public List<MovimentoEntity> listarMovimento() {
		return repoMovi.findAll();
	}
	
	@PostMapping("/lancamento")
	public LancamentoEntity novoLancamento(@RequestBody LancamentoEntity lance ) {
		return repoLance.save(lance);
	}
	@GetMapping("/lancamento")
	public List<LancamentoEntity> listarLancamento() {
		return repoLance.findAll();
	}
	@GetMapping("/lancamento/{id}/movimento")
	public List<MovimentoEntity> listarMovimentoDeLancamento(@PathVariable(name = "id") Integer id) {
		return repoLance.findById(id).get().getMovimentos();
	}
	
	@GetMapping("/meta")
	public List<MetaEntity> listarMeta() {
		return repoMeta.findAll();
	}
}
