package br.com.hessel.controle_financeiro.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hessel.controle_financeiro.model.entities.LancamentoEntity;
import br.com.hessel.controle_financeiro.model.enuns.TipoLancamento;
import br.com.hessel.controle_financeiro.model.exceptions.RecursoNaoEncontradoException;
import br.com.hessel.controle_financeiro.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repoLancamento;
	
	
	public List<LancamentoEntity> listarLancamento() {
		return repoLancamento.findAll();
	}
	public List<LancamentoEntity> listarLancamentoPorTipo(TipoLancamento tipo) {
		return repoLancamento.findAll().stream()
				.filter(lancamento -> lancamento.getTipoLancamento().equals(tipo))
				.toList();
	}
	public LancamentoEntity buscaLancamentoPorId(Integer idLancamento) {
		return repoLancamento.findById(idLancamento).orElseThrow(() -> new RecursoNaoEncontradoException(
						String.format("Não foi encontrado um Lançamento com código: %d", idLancamento)));
	}
	
	
	
	
}
