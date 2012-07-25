package com.sabio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;


@Audited
public class RG implements Serializable  {

	@Transient
	private static final long serialVersionUID = -2142960354314599647L;

	@NotEmpty(message="Número RG não pode ser vazio")	
	@Column (nullable = false, length = 30)
	private String numeroRG;
	
	@NotEmpty(message="Orgão emissor não pode ser vazio")
	@Column (nullable = false, length = 30)
	private String orgaoEmissorRG;
	
	@NotEmpty(message="UF do RG não pode ser vazio")	
	@Column (nullable = false, length = 2)
	private String UFRG;
	
	@NotNull(message="Data de emissão do RG é inválida")
	@Past(message="Data de emissão do RG é inválida")	
	@Column (nullable = false)
	@Temporal(TemporalType.DATE)
	private	Date dataEmissaoRG;

	public RG(){
	}

	public String getNumeroRG() {
		return numeroRG;
	}

	public void setNumeroRG(String numeroRG) {
		this.numeroRG = numeroRG;
	}

	public String getOrgaoEmissorRG() {
		return orgaoEmissorRG;
	}

	public void setOrgaoEmissorRG(String orgaoEmissorRG) {
		this.orgaoEmissorRG = orgaoEmissorRG;
	}

	public String getUFRG() {
		return UFRG;
	}

	public void setUFRG(String ufrg) {
		UFRG = ufrg;
	}

	public Date getDataEmissaoRG() {
		return dataEmissaoRG;
	}

	public void setDataEmissaoRG(Date dataEmissaoRG) {
		this.dataEmissaoRG = dataEmissaoRG;
	}

}
