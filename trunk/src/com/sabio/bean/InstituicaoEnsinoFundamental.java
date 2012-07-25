package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Transient;

public class InstituicaoEnsinoFundamental implements Serializable {

	@Transient
	private static final long serialVersionUID = 6991861280628996955L;

	@Column (length=100)
	private String nomeInstituicaoEnsinoFundamental;

	private int anoInstituicaoEnsinoFundamental;
	
	@Column (length=2)
	private String UFInstituicaoEnsinoFundamental;
	
	@Column (length=100)
	private String cidadeInstituicaoEnsinoFundamental;
	
	public InstituicaoEnsinoFundamental(){
		
	}

	public String getNomeInstituicaoEnsinoFundamental() {
		return nomeInstituicaoEnsinoFundamental;
	}

	public void setNomeInstituicaoEnsinoFundamental(String nomeInstituicaoEnsinoFundamental) {
		this.nomeInstituicaoEnsinoFundamental = nomeInstituicaoEnsinoFundamental;
	}

	public int getAnoInstituicaoEnsinoFundamental() {
		return anoInstituicaoEnsinoFundamental;
	}

	public void setAnoInstituicaoEnsinoFundamental(int anoInstituicaoEnsinoFundamental) {
		this.anoInstituicaoEnsinoFundamental = anoInstituicaoEnsinoFundamental;
	}

	public String getUFInstituicaoEnsinoFundamental() {
		return UFInstituicaoEnsinoFundamental;
	}

	public void setUFInstituicaoEnsinoFundamental(String instituicaoEnsinoFundamental) {
		UFInstituicaoEnsinoFundamental = instituicaoEnsinoFundamental;
	}

	public void setCidadeInstituicaoEnsinoFundamental(
			String cidadeIntituicaoEnsinoFundamental) {
		this.cidadeInstituicaoEnsinoFundamental = cidadeIntituicaoEnsinoFundamental;
	}

	public String getCidadeInstituicaoEnsinoFundamental() {
		return cidadeInstituicaoEnsinoFundamental;
	}
	
}
