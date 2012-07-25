package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import br.com.caelum.stella.hibernate.validator.CPF;


@Entity
@Audited
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 7373205801212697010L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoPessoa;
	
	@CPF(message="CPF inválido")
	@Column(nullable = false, length = 18)
	private String CPF;


	@Column (nullable=false, length=150)
	private String nome;
	
    
    public Pessoa(){
		
	}


	public int getCodigoPessoa() {
		return codigoPessoa;
	}


	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

}