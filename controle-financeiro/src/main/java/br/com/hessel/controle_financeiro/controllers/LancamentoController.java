package br.com.hessel.controle_financeiro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hessel.controle_financeiro.model.DTOs.LancamentoSimplesDto;
import br.com.hessel.controle_financeiro.model.enuns.TipoLancamento;
import br.com.hessel.controle_financeiro.model.services.LancamentoService;

@RestController
@RequestMapping(value = "/api/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService; 

	@GetMapping("/simples")
	public List<LancamentoSimplesDto> listarLancamentos(@RequestParam (required = false,name = "tipo") String tipo ) {
		List<LancamentoSimplesDto> lancamentoDto =null;
		if(tipo!=null &&(tipo.equalsIgnoreCase(TipoLancamento.DESPESA.name())|| tipo.equalsIgnoreCase(TipoLancamento.RECEITA.name()))){
			lancamentoDto= lancamentoService.listarLancamentoPorTipo(TipoLancamento.valueOf(tipo.toUpperCase())).stream()
				.map(lancamento -> new LancamentoSimplesDto(lancamento))
				.collect(Collectors.toList());
		}
		else {
			lancamentoDto= lancamentoService.listarLancamento().stream()
					.map(lancamento -> new LancamentoSimplesDto(lancamento))
					.collect(Collectors.toList());
		}
		return lancamentoDto;
	}
	@GetMapping("/simples/{id}")
	public LancamentoSimplesDto buscaLancamento(@PathVariable(name = "id") Integer id) {
		return new LancamentoSimplesDto(lancamentoService.buscaLancamentoPorId(id));
	}
}
