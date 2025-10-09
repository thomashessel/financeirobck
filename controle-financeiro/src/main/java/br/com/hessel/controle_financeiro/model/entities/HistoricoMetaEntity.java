package br.com.hessel.controle_financeiro.model.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.hessel.controle_financeiro.model.enuns.StatusMeta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "HISTORICO_META")
public class HistoricoMetaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "valor",nullable = false)
	private Double valor;
	@Column(name = "dt_Movimento",nullable = false)
	private LocalDate dataMovimento;
	@Column(name = "ciclo",nullable = true)
	private Integer ciclo;
	@Column(name = "st_atual",nullable = true)
	private StatusMeta statusFechamento;
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="meta_id")
	private MetaEntity meta;
	
	public MetaEntity getMeta() {
		return meta;
	}
	public void setMeta(MetaEntity meta) {
		this.meta = meta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public HistoricoMetaEntity(Integer metaId, Double valor, LocalDate dataMovimento) {
		this.meta.setId(metaId);
		this.valor = valor;
		this.dataMovimento = dataMovimento;
	}
	public HistoricoMetaEntity(Integer metaId, Double valor, LocalDate dataMovimento, Integer ciclo,
			StatusMeta statusFechamento) {
		this.meta.setId(metaId);
		this.valor = valor;
		this.dataMovimento = dataMovimento;
		this.ciclo = ciclo;
		this.statusFechamento = statusFechamento;
	}

	
	
	
	
}
