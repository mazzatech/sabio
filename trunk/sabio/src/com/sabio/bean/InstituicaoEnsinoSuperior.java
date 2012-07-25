package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Transient;

public class InstituicaoEnsinoSuperior implements Serializable {

	@Transient
	private static final long serialVersionUID = -3741477186805575884L;

	@Column (length=100)
	private String nomeInstituicaoEnsinoSuperior;

	private int anoInstituicaoEnsinoSuperior;
	
	@Column (length=2)
	private String UFInstituicaoEnsinoSuperior;
	
	@Column (length=100)
	private String cidadeInstituicaoEnsinoSuperior;

	
	public InstituicaoEnsinoSuperior(){
		
	}

	public String getNomeInstituicaoEnsinoSuperior() {
		return nomeInstituicaoEnsinoSuperior;
	}

	public void setNomeInstituicaoEnsinoSuperior(String nomeInstituicaoEnsinoSuperior) {
		this.nomeInstituicaoEnsinoSuperior = nomeInstituicaoEnsinoSuperior;
	}

	public int getAnoInstituicaoEnsinoSuperior() {
		return anoInstituicaoEnsinoSuperior;
	}

	public void setAnoInstituicaoEnsinoSuperior(int anoInstituicaoEnsinoSuperior) {
		this.anoInstituicaoEnsinoSuperior = anoInstituicaoEnsinoSuperior;
	}

	public String getUFInstituicaoEnsinoSuperior() {
		return UFInstituicaoEnsinoSuperior;
	}

	public void setUFInstituicaoEnsinoSuperior(String instituicaoEnsinoSuperior) {
		UFInstituicaoEnsinoSuperior = instituicaoEnsinoSuperior;
	}

	public void setCidadeInstituicaoEnsinoSuperior(
			String cidadeIntituicaoEnsinoMedio) {
		this.cidadeInstituicaoEnsinoSuperior = cidadeIntituicaoEnsinoMedio;
	}

	public String getCidadeInstituicaoEnsinoSuperior() {
		return cidadeInstituicaoEnsinoSuperior;
	}
	
}
