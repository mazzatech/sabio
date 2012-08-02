package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Parentesco implements Serializable{
	@Transient
	private static final long serialVersionUID = 6697397767525694833L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoParentesco;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoPessoa", insertable = true, updatable = true, nullable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Pessoa pessoa;

	@OneToOne
	private GrauParentesco grauParentesco;

	public Parentesco() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoParentesco() {
		return codigoParentesco;
	}

	public void setCodigoParentesco(int codigoParentesco) {
		this.codigoParentesco = codigoParentesco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoParentesco;
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
		Parentesco other = (Parentesco) obj;
		if (codigoParentesco != other.codigoParentesco)
			return false;
		return true;
	}

}
