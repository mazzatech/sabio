package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

public class CertidaoNascimento implements Serializable{

	private static final long serialVersionUID = 5927766188249687877L;

	@NotEmpty(message="O campo NUMERO nao pode ser vazio")
	@Column(length=30)
	private String numeroCertidaoNascimento;

	@NotEmpty(message="O campo LIVRO nao pode ser vazio")
	@Column(length=30)
	private String livro;

	@NotEmpty(message="O campo FOLHA nao pode ser vazio")
	@Column(length=30)
	private String folha;

	public CertidaoNascimento() {
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}



	public String getNumeroCertidaoNascimento() {
		return numeroCertidaoNascimento;
	}



	public void setNumeroCertidaoNascimento(String numeroCertidaoNascimento) {
		this.numeroCertidaoNascimento = numeroCertidaoNascimento;
	}
}
