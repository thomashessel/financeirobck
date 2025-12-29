package br.com.hessel.controle_financeiro.model.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.hessel.controle_financeiro.model.entities.ConfiguracoesEntity;
import br.com.hessel.controle_financeiro.model.entities.GrupoEntity;
import br.com.hessel.controle_financeiro.model.entities.LancamentoEntity;
import br.com.hessel.controle_financeiro.model.enuns.TipoLancamento;


public class LancamentoSimplesDto {

	private Integer id;
	private String nome;
	private TipoLancamento tipoLancamento;
	private Double valorTotal;
	private LocalDate dataVencimento;
	private String observacao;
	private Boolean ativo;
	private String grupo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	public LancamentoSimplesDto() {}
	public LancamentoSimplesDto(LancamentoEntity lancamento) {
		this.id = lancamento.getId();
		this.nome = lancamento.getNome();
		this.tipoLancamento = lancamento.getTipoLancamento();
		this.valorTotal = lancamento.getValorTotal();
		this.dataVencimento = lancamento.getDataVencimento();
		this.observacao = lancamento.getObservacao();
		this.ativo = lancamento.getAtivo();
		this.grupo = lancamento.getGrupo().getNome();
		
	}
	public LancamentoSimplesDto(Integer id, String nome, TipoLancamento tipoLancamento, Double valorTotal,
			LocalDate dataVencimento, String observacao, Boolean ativo, String grupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoLancamento = tipoLancamento;
		this.valorTotal = valorTotal;
		this.dataVencimento = dataVencimento;
		this.observacao = observacao;
		this.ativo = ativo;
		this.grupo = grupo;
	}
	
	public LancamentoEntity converteParaLancamento() {
		LancamentoEntity lancamento = new LancamentoEntity();
		lancamento.setId(this.id);
		lancamento.setNome(this.nome);
		lancamento.setTipoLancamento(this.tipoLancamento);
		lancamento.setValorTotal(this.valorTotal);
		lancamento.setDataVencimento(this.dataVencimento);
		lancamento.setObservacao(this.observacao);
		lancamento.setAtivo(this.ativo);
		lancamento.setGrupo(new GrupoEntity());
		lancamento.getGrupo().setNome(this.grupo);
		lancamento.setConfiguracoes(new ConfiguracoesEntity());
		lancamento.setMovimentos(new ArrayList<>());
		return lancamento;
	
	}
	
}
