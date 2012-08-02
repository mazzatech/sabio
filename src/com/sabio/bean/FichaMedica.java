package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class FichaMedica implements Serializable{
	@Transient
	private static final long serialVersionUID = 1566972366260613066L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoFichaMedica;
	private boolean alergico;
	private String alergias;
	private boolean tomaRemedio;
	private String remedios;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoPlanoSaude", insertable = true, updatable = true, nullable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private PlanoSaude planoSaude;

	public FichaMedica() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoFichaMedica() {
		return codigoFichaMedica;
	}

	public void setCodigoFichaMedica(int codigoFichaMedica) {
		this.codigoFichaMedica = codigoFichaMedica;
	}

	public boolean isAlergico() {
		return alergico;
	}

	public void setAlergico(boolean alergico) {
		this.alergico = alergico;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public boolean isTomaRemedio() {
		return tomaRemedio;
	}

	public void setTomaRemedio(boolean tomaRemedio) {
		this.tomaRemedio = tomaRemedio;
	}

	public String getRemedios() {
		return remedios;
	}

	public void setRemedios(String remedios) {
		this.remedios = remedios;
	}

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoFichaMedica;
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
		FichaMedica other = (FichaMedica) obj;
		if (codigoFichaMedica != other.codigoFichaMedica)
			return false;
		return true;
	}
}
