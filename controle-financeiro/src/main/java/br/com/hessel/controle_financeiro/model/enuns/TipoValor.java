package br.com.hessel.controle_financeiro.model.enuns;

public enum TipoValor {

	FIXO(1),
	ESTIMADO(2),
	VARIADO(3);

	private final Integer indice;
	TipoValor(Integer indice){
		this.indice=indice;
	}
	public Integer getIndice() {
		return indice;
	}
}
