package br.com.hessel.controle_financeiro.model.enuns;

public enum TipoRecorrencia {

	DIARIA(1),
	SEMANAL(2),
	QUINZENAL(3),
	MENSAL(4),
	VARIADO(5);

	private final Integer indice;
	TipoRecorrencia(Integer indice){
		this.indice=indice;
	}
	public Integer getIndice() {
		return indice;
	}
}
