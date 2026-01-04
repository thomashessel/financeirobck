package br.com.hessel.controle_financeiro.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hessel.controle_financeiro.model.entities.GrupoEntity;
import br.com.hessel.controle_financeiro.model.entities.LancamentoEntity;
import br.com.hessel.controle_financeiro.model.enuns.TipoLancamento;
import br.com.hessel.controle_financeiro.model.exceptions.FalhaRequisicaoException;
import br.com.hessel.controle_financeiro.model.exceptions.RecursoNaoEncontradoException;
import br.com.hessel.controle_financeiro.repositories.LancamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repoLancamento;
	@Autowired
	private CrudGrupoService grupoService;

	public List<LancamentoEntity> listaLancamentos() {
		return repoLancamento.findAll();
	}

	public List<LancamentoEntity> listaLancamentosPorTipo(TipoLancamento tipo) {
		return repoLancamento.findAll().stream()
				.filter(lancamento -> lancamento.getTipoLancamento().equals(tipo))
				.toList();
	}

	public LancamentoEntity buscaLancamentoPorId(Integer idLancamento) {
		return repoLancamento.findById(idLancamento).orElseThrow(() -> new RecursoNaoEncontradoException(
				String.format("Não foi encontrado um Lançamento com código: %d", idLancamento)));
	}

	@Transactional
	public void salvaLancamentoSimplificado(LancamentoEntity lancamento) {
		this.validaSimplificado(lancamento);		
		lancamento.setAtivo(true);
		repoLancamento.save(lancamento);
	}
	@Transactional
	public void alteraLancamentoSimplificado(Integer idLancamento,LancamentoEntity lancamento) {
		LancamentoEntity lancamentoResult = this.buscaLancamentoPorId(idLancamento);
		this.validaSimplificado(lancamento);
		lancamentoResult.setNome(lancamento.getNome());
		lancamentoResult.setValorTotal(lancamento.getValorTotal());
		lancamentoResult.setDataVencimento(lancamento.getDataVencimento());
		lancamentoResult.setTipoLancamento(lancamento.getTipoLancamento());
		lancamentoResult.setObservacao(lancamento.getObservacao());
		lancamentoResult.setGrupo(lancamento.getGrupo());
//		repoLancamento.save(lancamentoResult);
	}
	@Transactional
	public void cancelaLancamento(Integer idLancamento) {
		LancamentoEntity lancamentoResult = this.buscaLancamentoPorId(idLancamento);
		if(lancamentoResult.estaCancelado()) {
			throw new FalhaRequisicaoException("O lancamento selecionado já se encontra cancelado");
		}
		lancamentoResult.cancelar();
	}
	@Transactional
	public void alteraStatusAtivacao(Integer idLancamento,boolean status) {
		LancamentoEntity lancamentoResult = this.buscaLancamentoPorId(idLancamento);
		if(lancamentoResult.estaCancelado()) {
			throw new FalhaRequisicaoException("Não é possível seguir com a operação pois o lancamento já se encontra cancelado");
		}
		if(status) {
			lancamentoResult.ativar();
		}
		else {
			lancamentoResult.inativar();
		}
	}
	
	
 	private void validaSimplificado(LancamentoEntity lancamento) {
		if (lancamento.getConfiguracoes() != null) {
			throw new FalhaRequisicaoException("Não é possivel criar um lançamento rápido com configuração");
		}
		if (lancamento.getValorTotal() == null || lancamento.getValorTotal() == 0) {
			throw new FalhaRequisicaoException("O campo valor é obrigatório para lancamento rápido");
		}
		if (lancamento.getGrupo() != null) {
			 if(lancamento.getGrupo().getId() == null) {
				 throw new FalhaRequisicaoException("Não é possível localizar o grupo.");
			 }		
			GrupoEntity grupo = grupoService.listaGrupoPorId(lancamento.getGrupo().getId());
			if (lancamento.getTipoLancamento() != grupo.getTpoLancamento()) {
				throw new FalhaRequisicaoException("O lançamento e o grupo devem ser do mesmo tipo");
			}
		}		
	}
 	
 
 	
}
