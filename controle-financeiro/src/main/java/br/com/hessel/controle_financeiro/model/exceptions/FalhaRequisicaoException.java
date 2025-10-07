package br.com.hessel.controle_financeiro.model.exceptions;

public class FalhaRequisicaoException extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public FalhaRequisicaoException (String mensagem) {
		super(mensagem);
	}

}
