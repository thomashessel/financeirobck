package br.com.hessel.controle_financeiro.model.exceptions;

public class RecursoEmUsoException extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public RecursoEmUsoException (String mensagem) {
		super(mensagem);
	}

}
