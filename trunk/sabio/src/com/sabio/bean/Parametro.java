package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Parametro implements Serializable{
	
	private static final long serialVersionUID = 2820252843847802862L;

	@Id
	@NotEmpty(message="O campo CHAVE não pode ser vazio")
	@Column(length=50, nullable=false)
	private String chave;

	@Column(length=100)
	private String descricao;
	
	@NotEmpty(message="O campo VALOR não pode ser vazio")
	@Column(length=50, nullable=false)
	private String valor;
	
	public Parametro(){
		
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
