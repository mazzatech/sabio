package com.sabio.controle.cadastro;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;

import com.sabio.bean.Etnia;
import com.sabio.controle.ControleSession;
import com.sabio.servico.cadastro.EtniaServico;

@ManagedBean
@SessionScoped
public class ControleEtnia extends ControleSession implements Serializable{
	private static final long serialVersionUID = -7517459978933604163L;
	private Etnia etnia;
	private List<Etnia> lista;
	private String pesquisaDescricao;
	private String mensagem;
	private String retorno = "cadastro";
	private EtniaServico etniaServico;
	
	public ControleEtnia() {
		super("controleEtnia");
	}

	public Etnia getEtnia() {
		return etnia;
	}

	public void limpar(){
		lista 				= null;
		pesquisaDescricao	= null;
		mensagem			= null;
	}

	public String alterar(){
		return "cadastro";
	}

	public String incluir(){
		etnia = new Etnia();
		return "cadastro";
	}

	public String manutencao(){
		return "manutencao";
	}

	public void pesquisar(){
		setLista(getEtniaServico().pesquisar(pesquisaDescricao));
	}

	public String gravar(){

		try {
			getEtniaServico().gravar(etnia);
			if(getEtnia().getCodigoEtnia() == 0 ){
				setMensagem("Cadastro com Sucesso");
				retorno = "manutencao";
			}else{
				etnia = null;
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
			getEtniaServico().excluir(etnia);
		} catch (Exception e) {
			enviaMensagem(e.getMessage(), ControleSession.ERROR);
		}
		pesquisar();
		return "manutencao";
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}

	public List<Etnia> getLista() {
		return lista;
	}

	public void setLista(List<Etnia> lista) {
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

	public String getPesquisaDescricao() {
		return pesquisaDescricao;
	}

	public void setPesquisaDescricao(String pesquisaDescricao) {
		this.pesquisaDescricao = pesquisaDescricao;
	}

	public EtniaServico getEtniaServico() {
		if(etniaServico == null){
			etniaServico = new EtniaServico();
		}
		return etniaServico;
	}

	public void setEtniaServico(EtniaServico etniaServico) {
		this.etniaServico = etniaServico;
	}
}