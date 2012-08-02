package com.sabio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TituloEleitor implements Serializable {
	private static final long serialVersionUID = -8992933540786505147L;


	@Column(length=30)
	private String numeroTitulo ;
	

	@Column(length=20)
	private String zona;


	@Column(length=20)
	private String secao;
	

	@Temporal(TemporalType.DATE)
	private	Date dataEmissaoTituloEleitor;	
	

	@Column(length=100)
	private String cidadeTitulo;
	

	@Column(length=2)
	private String UFTitulo;
	
	
	public String getNumeroTitulo() {
		return numeroTitulo;
	}


	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getSecao() {
		return secao;
	}


	public void setSecao(String secao) {
		this.secao = secao;
	}


	public String getCidadeTitulo() {
		return cidadeTitulo;
	}


	public void setCidadeTitulo(String cidadeTitulo) {
		this.cidadeTitulo = cidadeTitulo;
	}


	public String getUFTitulo() {
		return UFTitulo;
	}


	public void setUFTitulo(String titulo) {
		UFTitulo = titulo;
	}


	public TituloEleitor(){
		
	}


	public Date getDataEmissaoTituloEleitor() {
		return dataEmissaoTituloEleitor;
	}


	public void setDataEmissaoTituloEleitor(Date dataEmissaoTituloEleitor) {
		this.dataEmissaoTituloEleitor = dataEmissaoTituloEleitor;
	}

}
