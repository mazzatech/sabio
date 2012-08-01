package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Audited
public class PlanoSaude implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4022439240301113313L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoPlanoSaude;

	@NotEmpty(message="O campo DESCRICAO nao pode ser vazio")
	@Column(length = 100,nullable = false)
	private String descricao;

	public PlanoSaude() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoPlanoSaude() {
		return codigoPlanoSaude;
	}

	public void setCodigoPlanoSaude(int codigoPlanoSaude) {
		this.codigoPlanoSaude = codigoPlanoSaude;
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
		result = prime * result + codigoPlanoSaude;
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
		PlanoSaude other = (PlanoSaude) obj;
		if (codigoPlanoSaude != other.codigoPlanoSaude)
			return false;
		return true;
	}
}
