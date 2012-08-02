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
public class GrauParentesco implements Serializable{
	@Transient
	private static final long serialVersionUID = -5966226919781742469L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoGrauParentesco;

	@NotEmpty(message="O campo DESCRICAO nao pode ser vazio")
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;

	public GrauParentesco() {
		// TODO Auto-generated constructor stub
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public int getCodigoGrauParentesco() {
		return codigoGrauParentesco;
	}



	public void setCodigoGrauParentesco(int codigoGrauParentesco) {
		this.codigoGrauParentesco = codigoGrauParentesco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoGrauParentesco;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
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
		GrauParentesco other = (GrauParentesco) obj;
		if (codigoGrauParentesco != other.codigoGrauParentesco)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

}
