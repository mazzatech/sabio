package com.sabio.bean;

import java.io.Serializable;

import javax.persistence.Column;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;


@Audited
public class Endereco implements Serializable {
 
	private static final long serialVersionUID = 3085315859671008307L;

	@NotEmpty(message="O campo ENDEREÇO não pode ser vazio")
	@Column (nullable = false, length =100)
	private String logradouro;
	
	@NotEmpty(message="NÚMERO não pode ser vazio")
	@Column (nullable = false, length =10, name="numeroLogradouro")
	private String numero;
	
	@Column (length =50)
	private String complemento;
	
	@NotEmpty(message="O campo BAIRRO não pode ser vazio")
	@Column (nullable = false, length =100)
	private String bairro;
	
	@NotEmpty(message="O campo CEP não pode ser vazio")
	@Column (nullable = false, length =9)
	private String CEP;
	
	@NotEmpty(message="Cidade não pode ser vazio")
	@Column (nullable = false, length =100)
	private String cidade;
	
	@NotEmpty(message="O campo UF cidade não pode ser vazio")
	@Column (nullable = false, length =2)
	private String UF;

	
	public Endereco(){
		
	}
		
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cep) {
		CEP = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uf) {
		UF = uf;
	}
	 
	
 
}
 
