package br.com.hessel.controle_financeiro.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOVIMENTO")
public class MovimentoEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "lancamento_id",nullable = false)
	private LancamentoEntity lancamento;
	@Column(name = "dt_movimento",nullable = false)
	private LocalDate dataMovimento;
	@Column(name = "valor",nullable = false)
	private Double valor;
	@Column(name = "num_ocorrencia",nullable = true)
	private Integer numeroOcorrencia;
	@Column(name = "st_baixa",nullable = false)
	private Boolean statusBaixa;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LancamentoEntity getLancamento() {
		return lancamento;
	}
	public void setLancamento(LancamentoEntity lancamento) {
		this.lancamento = lancamento;
	}
	public LocalDate getDataMovimento() {
		return dataMovimento;
	}
	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getNumeroOcorrencia() {
		return numeroOcorrencia;
	}
	public void setNumeroOcorrencia(Integer numeroOcorrencia) {
		this.numeroOcorrencia = numeroOcorrencia;
	}
	public Boolean getStatusBaixa() {
		return statusBaixa;
	}
	public void setStatusBaixa(Boolean statusBaixa) {
		this.statusBaixa = statusBaixa;
	}
	public MovimentoEntity() {}
	public MovimentoEntity(LancamentoEntity lancamento, LocalDate dataMovimento, Double valor, Integer numeroOcorrencia,
			Boolean statusBaixa) {
		super();
		this.lancamento = lancamento;
		this.dataMovimento = dataMovimento;
		this.valor = valor;
		this.numeroOcorrencia = numeroOcorrencia;
		this.statusBaixa = statusBaixa;
	}
	
	
}
