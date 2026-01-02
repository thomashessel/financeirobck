package br.com.hessel.controle_financeiro.model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import br.com.hessel.controle_financeiro.model.enuns.TipoLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LANCAMENTO")
public class LancamentoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome",nullable = false,length = 30)
	private String nome;
	@Column(name = "tp_lancamento",nullable = false)
	private TipoLancamento tipoLancamento;
	@Column(name = "vl_total",nullable = true)
	private Double valorTotal;
	@Column(name = "dt_vencimento",nullable = true)
	private LocalDate dataVencimento;
	@CreationTimestamp
	@Column(name = "dt_cadastro",nullable = false)
	private LocalDate dataCadastro;
	@Column(name = "dt_inativo",nullable = true)
	private LocalDate dataInativo;
	@Column(name = "dt_cancelamento",nullable = true)
	private LocalDate dataCancelamento;
	@Column(name = "ativo",nullable = true)
	private Boolean ativo;
	@Column(name = "observacao",nullable = true,length = 120)
	private String observacao;
	
	@ManyToOne()
	@JoinColumn(name = "grupo_id",nullable = true)
	private GrupoEntity grupo;
	
	@OneToOne
	@JoinColumn(name = "configuracao_id",nullable = true)
	private ConfiguracoesEntity configuracoes;
	
	@OneToMany(mappedBy = "lancamento", fetch = FetchType.LAZY)
	private List<MovimentoEntity> movimentos;
	
	
	
	public List<MovimentoEntity> getMovimentos() {
		return movimentos;
	}
	public void setMovimentos(List<MovimentoEntity> movimentos) {
		this.movimentos = movimentos;
	}
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
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public LocalDate getDataInativo() {
		return dataInativo;
	}
	public void setDataInativo(LocalDate dataInativo) {
		this.dataInativo = dataInativo;
	}
	public LocalDate getDataCancelamento() {
		return dataCancelamento;
	}
	public void setDataCancelamento(LocalDate dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public GrupoEntity getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoEntity grupo) {
		this.grupo = grupo;
	}
	public ConfiguracoesEntity getConfiguracoes() {
		return configuracoes;
	}
	public void setConfiguracoes(ConfiguracoesEntity configuracoes) {
		this.configuracoes = configuracoes;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LancamentoEntity other = (LancamentoEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	public LancamentoEntity() {}
	public LancamentoEntity(String nome, TipoLancamento tipoLancamento, Double valorTotal, LocalDate dataVencimento,
			LocalDate dataCadastro, LocalDate dataInativo, LocalDate dataCancelamento, Boolean ativo, String observacao,
			GrupoEntity grupo, ConfiguracoesEntity configuracoes) {
		super();
		this.nome = nome;
		this.tipoLancamento = tipoLancamento;
		this.valorTotal = valorTotal;
		this.dataVencimento = dataVencimento;
		this.dataCadastro = dataCadastro;
		this.dataInativo = dataInativo;
		this.dataCancelamento = dataCancelamento;
		this.ativo = ativo;
		this.observacao = observacao;
		this.grupo = grupo;
		this.configuracoes = configuracoes;
	}
	
	public void adicionaMovimento(MovimentoEntity movimento) {
		this.movimentos.add(movimento);
	}
	public void removeMovimento (MovimentoEntity movimento) {
		this.movimentos.remove(movimento);
	}
	
	
}
