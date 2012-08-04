package com.sabio.controle.cadastro;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;

import com.sabio.util.Listas;
import com.sabio.bean.Pessoa;
import com.sabio.controle.ControleSession;
import com.sabio.servico.cadastro.PessoaServico;

@ManagedBean
@SessionScoped
public class ControlePessoa extends ControleSession implements Serializable{
	private static final long serialVersionUID = -7517459978933604163L;
	private Pessoa pessoa;
	private List<Pessoa> lista;
	private List<String> listaSexos;
	private List<String> listaEstadoCivis;
	private List<String> listaNacionalidades;
	private String pesquisaCPF;
	private String pesquisaRG;
	private String pesquisaNome;
	private String mensagem;
	private String retorno = "cadastro";
	private PessoaServico pessoaServico;
	
	public ControlePessoa() {
		super("controlePessoa");
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void limpar(){
		lista 				= null;
		pesquisaCPF			= null;
		pesquisaRG			= null;
		pesquisaNome		= null;
		mensagem			= null;
	}

	public String alterar(){
		return "cadastro";
	}

	public String incluir(){
		pessoa = new Pessoa();
		return "cadastro";
	}

	public String manutencao(){
		return "manutencao";
	}

	public void pesquisar(){
		setLista(getPessoaServico().pesquisar(pesquisaCPF, pesquisaRG, pesquisaNome));
	}

	public String gravar(){

		try {
			getPessoaServico().gravar(pessoa);
			if(getPessoa().getCodigoPessoa() == 0 ){
				setMensagem("Cadastro com Sucesso");
				retorno = "manutencao";
			}else{
				pessoa = null;
				retorno = "manutencao";
				setMensagem("Altera&ccedil;&atilde;o com Sucesso");
			}
			pesquisar();
			enviaMensagem(mensagem, ControleSession.INFO);
		} catch (Exception e) {
			setMensagem("erro: "+e.getMessage());
			retorno = "cadastro";
			enviaMensagem(mensagem, ControleSession.ERROR);
		}
		return retorno;
	}

	public String excluir(){
		try {
			getPessoaServico().excluir(pessoa);
		} catch (Exception e) {
			enviaMensagem(e.getMessage(), ControleSession.ERROR);
		}
		pesquisar();
		return "manutencao";
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void retorna(CloseEvent event) throws IOException {
		FacesContext faces = FacesContext.getCurrentInstance();   
		ExternalContext context = faces.getExternalContext();   
		context.redirect(retorno+".jsf");
	}

	public String getPesquisaCPF() {
		return pesquisaCPF;
	}

	public void setPesquisaCPF(String pesquisaCPF) {
		this.pesquisaCPF = pesquisaCPF;
	}

	public String getPesquisaRG() {
		return pesquisaRG;
	}

	public void setPesquisaRG(String pesquisaRG) {
		this.pesquisaRG = pesquisaRG;
	}

	public String getPesquisaNome() {
		return pesquisaNome;
	}

	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}

	public PessoaServico getPessoaServico() {
		if(pessoaServico == null){
			pessoaServico = new PessoaServico();
		}
		return pessoaServico;
	}

	public void setPessoaServico(PessoaServico pessoaServico) {
		this.pessoaServico = pessoaServico;
	}

	public List<String> getListaSexos() {
		if(listaSexos == null){
			listaSexos = (new Listas()).getSexos();
		}
		return listaSexos;
	}

	public void setListaSexos(List<String> listaSexos) {
		this.listaSexos = listaSexos;
	}

	public List<String> getListaEstadoCivis() {
		if(listaEstadoCivis == null){
			listaEstadoCivis = (new Listas()).getEstadoCivil();
		}
		return listaEstadoCivis;
	}

	public void setListaEstadoCivis(List<String> listaEstadoCivis) {
		this.listaEstadoCivis = listaEstadoCivis;
	}

	public List<String> getListaNacionalidades() {
		if(listaNacionalidades == null){
			listaNacionalidades = (new Listas()).getNacionalidade();
		}
		return listaNacionalidades;
	}

	public void setListaNacionalidades(List<String> listaNacionalidades) {
		this.listaNacionalidades = listaNacionalidades;
	}
}