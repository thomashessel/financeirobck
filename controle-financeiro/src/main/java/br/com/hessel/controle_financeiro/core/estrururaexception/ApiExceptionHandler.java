package br.com.hessel.controle_financeiro.core.estrururaexception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hessel.controle_financeiro.model.exceptions.FalhaRequisicaoException;
import br.com.hessel.controle_financeiro.model.exceptions.RecursoEmUsoException;
import br.com.hessel.controle_financeiro.model.exceptions.RecursoNaoEncontradoException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<?> RespostaRecursoNaoEncontradoException(RecursoNaoEncontradoException e) {
		MensagemRespostaException mensagem = new MensagemRespostaException(e.getMessage(), OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
	}
	@ExceptionHandler(RecursoEmUsoException.class)
	public ResponseEntity<?> RespostaRecursoEmUsoException(RecursoEmUsoException e) {
		MensagemRespostaException mensagem = new MensagemRespostaException(e.getMessage(), OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(mensagem);
	}
	@ExceptionHandler(FalhaRequisicaoException.class)
	public ResponseEntity<?> RespostaFalhaRequisicaoException(FalhaRequisicaoException e) {
		MensagemRespostaException mensagem = new MensagemRespostaException(e.getMessage(), OffsetDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
	}
}
