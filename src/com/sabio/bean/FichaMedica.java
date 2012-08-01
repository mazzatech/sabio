package com.sabio.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class FichaMedica {
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
}
