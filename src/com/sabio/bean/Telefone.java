package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

public class Telefone implements Serializable{
	private static final long serialVersionUID = 8713489056418128522L;

	@Column(length = 2)
	private int codigoArea;

	@NotEmpty(message="O campo numero nao pode ser vazio")
	@Column(nullable = false, length = 30)
	private String numeroTelefone;

	@NotEmpty(message="O campo numero nao pode ser vazio")
	@Column(nullable = false, length = 20)
	private String tipo;

	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
}
