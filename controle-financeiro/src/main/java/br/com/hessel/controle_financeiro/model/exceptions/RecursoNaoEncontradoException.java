package br.com.hessel.controle_financeiro.model.exceptions;

public class RecursoNaoEncontradoException extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}

}
