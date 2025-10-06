package br.com.hessel.controle_financeiro.core.estrururaexception;

import java.time.OffsetDateTime;
import java.util.List;

public class MensagemRespostaException {

	private String mensagem;
	private OffsetDateTime ocorrenciaEvento;
	private List<PropriedadesErro> propriedadesErros=null;

	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public OffsetDateTime getOcorrenciaEvento() {
		return ocorrenciaEvento;
	}
	public void setOcorrenciaEvento(OffsetDateTime ocorrenciaEvento) {
		this.ocorrenciaEvento = ocorrenciaEvento;
	}
	public List<PropriedadesErro> getPropriedadesErros() {
		return propriedadesErros;
	}
	public void setPropriedadesErros(List<PropriedadesErro> propriedadesErros) {
		this.propriedadesErros = propriedadesErros;
	}
	public MensagemRespostaException() {}
	public MensagemRespostaException(String mensagem, OffsetDateTime ocorrenciaEvento) {
		this.mensagem = mensagem;
		this.ocorrenciaEvento = ocorrenciaEvento;
	}
	public MensagemRespostaException(String mensagem, OffsetDateTime ocorrenciaEvento,
			List<PropriedadesErro> propriedadesErros) {
		this.mensagem = mensagem;
		this.ocorrenciaEvento = ocorrenciaEvento;
		this.propriedadesErros = propriedadesErros;
	}
	
	
}
