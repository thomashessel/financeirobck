package br.com.hessel.controle_financeiro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hessel.controle_financeiro.model.DTOs.LancamentoSimplesDto;
import br.com.hessel.controle_financeiro.model.entities.LancamentoEntity;
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
			lancamentoDto= lancamentoService.listaLancamentosPorTipo(TipoLancamento.valueOf(tipo.toUpperCase())).stream()
				.map(lancamento -> new LancamentoSimplesDto(lancamento))
				.collect(Collectors.toList());
		}
		else {
			lancamentoDto= lancamentoService.listaLancamentos().stream()
					.map(lancamento -> new LancamentoSimplesDto(lancamento))
					.collect(Collectors.toList());
		}
		return lancamentoDto;
	}
	@GetMapping("/simples/{id}")
	public LancamentoSimplesDto buscarLancamento(@PathVariable(name = "id") Integer id) {
		return new LancamentoSimplesDto(lancamentoService.buscaLancamentoPorId(id));
	}
	@PostMapping("/simples")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void salvarLancamentoSimples(@RequestBody LancamentoEntity lancamento) {
		lancamentoService.salvaLancamentoSimplificado(lancamento);
	}
	@DeleteMapping("/{id}/cancelar")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void cancelarLancamento(@PathVariable(name = "id") Integer id) {
		lancamentoService.cancelaLancamento(id);
		
	}
	@PutMapping("/simples/{id}/alterar")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void alterarLancamentoSimples(@PathVariable(name = "id") Integer id,@RequestBody LancamentoEntity lancamento) {
		lancamentoService.alteraLancamentoSimplificado(id, lancamento);
	}
	@PatchMapping("/{id}/inativar")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable(name = "id") Integer id) {
		lancamentoService.alteraStatusAtivacao(id,false);
	}
	@PatchMapping("/{id}/ativar")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable(name = "id") Integer id) {
		lancamentoService.alteraStatusAtivacao(id,true);
	}
}
