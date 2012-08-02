package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Etnia implements Serializable{
	@Transient
	private static final long serialVersionUID = -2118330138677060830L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoEtnia;

	@NotEmpty(message="O campo SITE não pode ser vazio")
	@Column (nullable=false, length=100)
	private String descricao;

	public Etnia() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoEtnia() {
		return codigoEtnia;
	}

	public void setCodigoEtnia(int codigoEtnia) {
		this.codigoEtnia = codigoEtnia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoEtnia;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etnia other = (Etnia) obj;
		if (codigoEtnia != other.codigoEtnia)
			return false;
		return true;
	}
}
