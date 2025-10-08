package br.com.hessel.controle_financeiro.model.entities;

import java.time.LocalDate;

import br.com.hessel.controle_financeiro.model.enuns.StatusMeta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HISTORICO_META")
public class HistoricoMetaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "meta_id",nullable = false)
	private Integer metaId;
	@Column(name = "valor",nullable = false)
	private Double valor;
	@Column(name = "dt_Movimento",nullable = false)
	private LocalDate dataMovimento;
	@Column(name = "ciclo",nullable = true)
	private Integer ciclo;
	@Column(name = "st_atual",nullable = true)
	private StatusMeta statusFechamento;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMetaId() {
		return metaId;
	}
	public void setMetaId(Integer metaId) {
		this.metaId = metaId;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDate getDataMovimento() {
		return dataMovimento;
	}
	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
	public Integer getCiclo() {
		return ciclo;
	}
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}
	public StatusMeta getStatusFechamento() {
		return statusFechamento;
	}
	public void setStatusFechamento(StatusMeta statusFechamento) {
		this.statusFechamento = statusFechamento;
	}
	
	public HistoricoMetaEntity() {}
	public HistoricoMetaEntity(Integer metaId, Double valor, LocalDate dataMovimento, Integer ciclo,
			StatusMeta statusFechamento) {
		this.metaId = metaId;
		this.valor = valor;
		this.dataMovimento = dataMovimento;
		this.ciclo = ciclo;
		this.statusFechamento = statusFechamento;
	}

	
	
	
	
}
