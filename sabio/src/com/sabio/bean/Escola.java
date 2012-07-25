package com.sabio.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.stella.hibernate.validator.CNPJ;


@Entity
@Audited
public class Escola implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoEscola;

	@NotEmpty(message="O campo CNPJ não pode ser vazio")
	@CNPJ(message="CNPJ inválido")
	@Column(nullable = false, length = 18)
	private String CNPJ;

	@NotEmpty(message="O campo DESCRIÇÃO não pode ser vazio")
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;

	@NotEmpty(message="O campo INSCRIÇÃO ESTADUAL não pode ser vazio")
	@Column (nullable=true, length=30)
	private	String inscricaoEstadual;

	@NotEmpty(message="O campo INSCRIÇÃO MUNICIPAL não pode ser vazio")
	@Column (nullable=true, length=30)
	private String inscricaoMunicipal;

	@Embedded
	private Endereco endereco;

	@NotEmpty(message="O campo TELEFONE não pode ser vazio")
	@Column (nullable = false, length=20)
	private String telefone;	

	@Column (length=20)
	private String fax;	

	@NotEmpty(message="O campo SITE não pode ser vazio")
	@Column (nullable=false, length=100)
	private String site;

	@NotEmpty(message="O campo EMAIL não pode ser vazio")
	@Email
	@Column (nullable=false, length=150)
	private String email;

	private String logomarca;	

	public Escola(){
	}

	public int getCodigoEscola() {
		return codigoEscola;
	}

	public void setCodigoEscola(int codigoEscola) {
		this.codigoEscola = codigoEscola;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Escola escola){
		if (this.getCodigoEscola() == (escola.getCodigoEscola()) ){
			return true;
		}else
			return false;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cnpj) {
		CNPJ = cnpj;
	}

	public String getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(String logomarca) {
		this.logomarca = logomarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoEscola;
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
		Escola other = (Escola) obj;
		if (codigoEscola != other.codigoEscola)
			return false;
		return true;
	}



	
}
