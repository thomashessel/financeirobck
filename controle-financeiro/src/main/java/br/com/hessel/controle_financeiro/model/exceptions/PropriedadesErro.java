package br.com.hessel.controle_financeiro.model.exceptions;

public class PropriedadesErro {

	private String nomeCampo;
	private String motivoErro;
	
	public String getNomeCampo() {
		return nomeCampo;
	}
	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}
	public String getMotivoErro() {
		return motivoErro;
	}
	public void setMotivoErro(String motivoErro) {
		this.motivoErro = motivoErro;
	}
}
