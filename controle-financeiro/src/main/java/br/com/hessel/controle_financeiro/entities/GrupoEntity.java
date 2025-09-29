package br.com.hessel.controle_financeiro.entities;

import br.com.hessel.controle_financeiro.utils.enuns.TipoLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "GRUPO")
public class GrupoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome",nullable = false,length = 30)
	private String nome;
	
	@Column(name = "tp_lancamento",nullable = false)
	private TipoLancamento tpoLancamento;

	public GrupoEntity(String nome, TipoLancamento tpoLancamento) {
		this.nome = nome;
		this.tpoLancamento = tpoLancamento;
	}
	
	public GrupoEntity() {}

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

	public TipoLancamento getTpoLancamento() {
		return tpoLancamento;
	}

	public void setTpoLancamento(TipoLancamento tpoLancamento) {
		this.tpoLancamento = tpoLancamento;
	}
	
	
	
}
