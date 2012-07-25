package com.sabio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

@Audited
public class Reservista implements Serializable {
	
	@Transient
	private static final long serialVersionUID = -1264087838042214850L;

	@Column(length = 30)
	private String numeroReservista;
	 
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoReservista;

	@Column (length=50)
	private String orgaoEmissorReservista;
	
	@Column (length=20)
	private String serieReservista;
	
	public Reservista(){
		
	}


	public String getNumeroReservista() {
		return numeroReservista;
	}


	public void setNumeroReservista(String numeroReservista) {
		this.numeroReservista = numeroReservista;
	}


	public String getOrgaoEmissorReservista() {
		return orgaoEmissorReservista;
	}


	public void setOrgaoEmissorReservista(String orgaoEmissorReservista) {
		this.orgaoEmissorReservista = orgaoEmissorReservista;
	}


	public String getSerieReservista() {
		return serieReservista;
	}


	public void setSerieReservista(String serieReservista) {
		this.serieReservista = serieReservista;
	}


	public Date getDataEmissaoReservista() {
		return dataEmissaoReservista;
	}


	public void setDataEmissaoReservista(Date dataEmissaoReservista) {
		this.dataEmissaoReservista = dataEmissaoReservista;
	}


	

}
