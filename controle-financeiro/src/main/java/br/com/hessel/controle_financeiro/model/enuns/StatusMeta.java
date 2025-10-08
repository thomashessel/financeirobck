package br.com.hessel.controle_financeiro.model.enuns;

public enum StatusMeta {
	ABAIXO_META(1),
	PROXIMO_META(2),
	ATINGIU_META(3),
	PASSOU_META(4);

	private final Integer indice;
	StatusMeta(Integer indice){
		this.indice=indice;
	}
	public Integer getIndice() {
		return indice;
	}
}

