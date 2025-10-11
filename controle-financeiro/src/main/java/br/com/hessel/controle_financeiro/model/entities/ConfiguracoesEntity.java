package br.com.hessel.controle_financeiro.model.entities;

import java.time.LocalDate;

import br.com.hessel.controle_financeiro.model.enuns.TipoRecorrencia;
import br.com.hessel.controle_financeiro.model.enuns.TipoValor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONFIGURACAO")
public class ConfiguracoesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "dt_cadastro",nullable = false)
	private LocalDate dataCadastro;
	@Column(name = "tp_recorrencia",nullable = false)
	private TipoRecorrencia tipoRecorrencia;
	@Column(name = "semanal",nullable = true,length = 12)
	private String diaSemana;
	@Column(name = "quinzenal",nullable = true,length = 6)
	private String diaQuinzena;
	@Column(name = "mensal",nullable = true)
	private Integer diaMes;
	@Column(name = "qtd_ocorrencia",nullable = true)
	private Integer qdteOcorrencia;
	@Column(name = "dt_inicial",nullable = true)
	private LocalDate dataInicial;
	@Column(name = "dt_inicial",nullable = true)
	private LocalDate dataFinal;
	@Column(name = "tp_valor",nullable = false)
	private TipoValor tipoValor;
	@Column(nullable = false)
	private Boolean automatico;
	@Column(nullable = false)
	private Boolean notificacao;
	
	@OneToOne
	@JoinColumn(name = "meta_id",nullable = true)
	private MetaEntity meta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoRecorrencia getTipoRecorrencia() {
		return tipoRecorrencia;
	}

	public void setTipoRecorrencia(TipoRecorrencia tipoRecorrencia) {
		this.tipoRecorrencia = tipoRecorrencia;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDiaQuinzena() {
		return diaQuinzena;
	}

	public void setDiaQuinzena(String diaQuinzena) {
		this.diaQuinzena = diaQuinzena;
	}

	public Integer getDiaMes() {
		return diaMes;
	}

	public void setDiaMes(Integer diaMes) {
		this.diaMes = diaMes;
	}

	public Integer getQdteOcorrencia() {
		return qdteOcorrencia;
	}

	public void setQdteOcorrencia(Integer qdteOcorrencia) {
		this.qdteOcorrencia = qdteOcorrencia;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public TipoValor getTipoValor() {
		return tipoValor;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public Boolean getAutomatico() {
		return automatico;
	}

	public void setAutomatico(Boolean automatico) {
		this.automatico = automatico;
	}

	public Boolean getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Boolean notificacao) {
		this.notificacao = notificacao;
	}
	public ConfiguracoesEntity() {}
	public ConfiguracoesEntity(LocalDate dataCadastro, TipoRecorrencia tipoRecorrencia, String diaSemana,
			String diaQuinzena, Integer diaMes, Integer qdteOcorrencia, LocalDate dataInicial, LocalDate dataFinal,
			TipoValor tipoValor, Boolean automatico, Boolean notificacao, MetaEntity meta) {
		super();
		this.dataCadastro = dataCadastro;
		this.tipoRecorrencia = tipoRecorrencia;
		this.diaSemana = diaSemana;
		this.diaQuinzena = diaQuinzena;
		this.diaMes = diaMes;
		this.qdteOcorrencia = qdteOcorrencia;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.tipoValor = tipoValor;
		this.automatico = automatico;
		this.notificacao = notificacao;
		this.meta = meta;
	}
	
	public void adicionarMeta (MetaEntity meta) {
		this.meta=meta;
	}
	
	
	
}
