package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Transient;

public class InstituicaoEnsinoMedio implements Serializable {

	@Transient
	private static final long serialVersionUID = -6356407306628943551L;

	@Column (length=100)
	private String nomeInstituicaoEnsinoMedio;

	private int anoInstituicaoEnsinoMedio;

	@Column (length=2)
	private String UFInstituicaoEnsinoMedio;

	@Column (length=100)
	private String cidadeInstituicaoEnsinoMedio;
	
	public InstituicaoEnsinoMedio(){
		
	}

	public String getNomeInstituicaoEnsinoMedio() {
		return nomeInstituicaoEnsinoMedio;
	}

	public void setNomeInstituicaoEnsinoMedio(String nomeInstituicaoEnsinoMedio) {
		this.nomeInstituicaoEnsinoMedio = nomeInstituicaoEnsinoMedio;
	}

	public int getAnoInstituicaoEnsinoMedio() {
		return anoInstituicaoEnsinoMedio;
	}

	public void setAnoInstituicaoEnsinoMedio(int anoInstituicaoEnsinoMedio) {
		this.anoInstituicaoEnsinoMedio = anoInstituicaoEnsinoMedio;
	}

	public String getUFInstituicaoEnsinoMedio() {
		return UFInstituicaoEnsinoMedio;
	}

	public void setUFInstituicaoEnsinoMedio(String instituicaoEnsinoMedio) {
		UFInstituicaoEnsinoMedio = instituicaoEnsinoMedio;
	}

	public void setCidadeInstituicaoEnsinoMedio(
			String cidadeIntituicaoEnsinoMedio) {
		this.cidadeInstituicaoEnsinoMedio = cidadeIntituicaoEnsinoMedio;
	}

	public String getCidadeInstituicaoEnsinoMedio() {
		return cidadeInstituicaoEnsinoMedio;
	}
	
}
