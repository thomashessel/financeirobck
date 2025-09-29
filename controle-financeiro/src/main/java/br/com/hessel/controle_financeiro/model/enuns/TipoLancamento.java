package br.com.hessel.controle_financeiro.model.enuns;

public enum TipoLancamento {
	DESPESA(1),
	RECEITA(2);

	private final Integer indice;
	TipoLancamento(Integer indice){
		this.indice=indice;
	}
	public Integer getIndice() {
		return indice;
	}

}
