package com.sabio.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.stella.hibernate.validator.CPF;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 7373205801212697010L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int codigoPessoa;
	
	@CPF(message="CPF inválido")
	@Column(nullable = false, length = 18)
	private String CPF;

	@NotEmpty(message="O campo RG nao pode ser vazio")
	@Column(nullable = false, length = 18)
	private String RG;

	@Column (nullable=false, length=150)
	private String nome;
	
	@NotEmpty(message="DATA NASCIMENTO e invalida")
	@Column (nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@NotEmpty(message="O campo SEXO nao pode ser vazio")
	@Column(nullable=false, length=20)
	private String sexo;

	@NotEmpty(message="O campo NACIONALIDADE nao pode ser vazio")
	@Column(nullable=false, length=100)
	private String nacionalidade;

	@NotEmpty(message="O campo ESTADO CIVIL nao pode ser vazio")
	@Column(nullable=false, length=30)
	private String estadoCivil;

	@Email
	@Column(length=100)
	private String email;

	@NotEmpty(message="O campo ESCOLARIDADE nao pode ser vazio")
	@Column(length=100)
	private String escolaridade;

	@NotEmpty(message="O campo PROFISSAO nao pode ser vazio")
	@Column(length=100)
	private String profissao;

	@Embedded
	private CertidaoNascimento certidaoNascimento;

	@Embedded
	private Telefone telefone;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Parentescos",
	joinColumns=@JoinColumn(name="codigoPessoa"),
	inverseJoinColumns=@JoinColumn(name="codigoParentesco"))
	private Collection<Parentesco> parentescos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoEtnia", insertable = true, updatable = true, nullable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Etnia etnia;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoFichaMedica", insertable = true, updatable = true, nullable = false)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private FichaMedica fichaMedica;

    public Pessoa(){
	}

	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public CertidaoNascimento getCertidaoNascimento() {
		return certidaoNascimento;
	}

	public void setCertidaoNascimento(CertidaoNascimento certidaoNascimento) {
		this.certidaoNascimento = certidaoNascimento;
	}

	public Collection<Parentesco> getParentescos() {
		return parentescos;
	}

	public void setParentescos(Collection<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}

	public Etnia getEtnia() {
		return etnia;
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}

	public FichaMedica getFichaMedica() {
		return fichaMedica;
	}

	public void setFichaMedica(FichaMedica fichaMedica) {
		this.fichaMedica = fichaMedica;
	}
}