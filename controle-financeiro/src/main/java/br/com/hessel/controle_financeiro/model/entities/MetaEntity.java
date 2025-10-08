package br.com.hessel.controle_financeiro.model.entities;

import br.com.hessel.controle_financeiro.model.enuns.StatusMeta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "META")
public class MetaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "vl_meta",nullable = false)
	private Double vlMeta;
	@Column(name = "vl_somado",nullable = true)
	private Double vlSoma;
	@Column(name = "ciclo_atual",nullable = true)
	private Integer cicloAtual;
	@Column(name = "st_atual",nullable = false)
	private StatusMeta status;
	@Column(name = "margem_percentual",nullable = true)
	private Double margemPercentual;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getVlMeta() {
		return vlMeta;
	}
	public void setVlMeta(Double vlMeta) {
		this.vlMeta = vlMeta;
	}
	public StatusMeta getStatus() {
		return status;
	}
	public void setStatus(StatusMeta status) {
		this.status = status;
	}
	public Double getMargemPercentual() {
		return margemPercentual;
	}
	public void setMargemPercentual(Double margemPercentual) {
		this.margemPercentual = margemPercentual;
	}
	public Double getVlSoma() {
		return vlSoma;
	}
	public Integer getCicloAtual() {
		return cicloAtual;
	}
	
	public MetaEntity() {	}	
	public MetaEntity(Double vlMeta) {
		this.vlMeta = vlMeta;
	}
	public MetaEntity(Double vlMeta, Double margemPercentual) {
		this.vlMeta = vlMeta;
		this.margemPercentual = margemPercentual;
	}

	public void atualizaTotal(Double valorDeSoma) {
		vlSoma+=valorDeSoma;
	}
	public void proximoCiclo() {
		cicloAtual+=1;
	}
	
}
