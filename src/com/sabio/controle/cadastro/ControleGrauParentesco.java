package com.sabio.controle.cadastro;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;

import com.sabio.bean.GrauParentesco;
import com.sabio.controle.ControleSession;
import com.sabio.servico.cadastro.GrauParentescoServico;

@ManagedBean
@SessionScoped
public class ControleGrauParentesco extends ControleSession implements Serializable{
	private static final long serialVersionUID = -7517459978933604163L;
	private GrauParentesco grauParentesco;
	private List<GrauParentesco> lista;
	private String pesquisaDescricao;
	private String mensagem;
	private String retorno = "cadastro";
	private GrauParentescoServico grauParentescoServico;
	
	public ControleGrauParentesco() {
		super("controleGrauParentesco");
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
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
		grauParentesco = new GrauParentesco();
		return "cadastro";
	}

	public String manutencao(){
		return "manutencao";
	}

	public void pesquisar(){
		setLista(getGrauParentescoServico().pesquisar(pesquisaDescricao));
	}

	public String gravar(){

		try {
			getGrauParentescoServico().gravar(grauParentesco);
			if(getGrauParentesco().getCodigoGrauParentesco() == 0 ){
				setMensagem("Cadastro com Sucesso");
				retorno = "manutencao";
			}else{
				grauParentesco = null;
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
			getGrauParentescoServico().excluir(grauParentesco);
		} catch (Exception e) {
			enviaMensagem(e.getMessage(), ControleSession.ERROR);
		}
		pesquisar();
		return "manutencao";
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public List<GrauParentesco> getLista() {
		return lista;
	}

	public void setLista(List<GrauParentesco> lista) {
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

	public GrauParentescoServico getGrauParentescoServico() {
		if(grauParentescoServico == null){
			grauParentescoServico = new GrauParentescoServico();
		}
		return grauParentescoServico;
	}

	public void setGrauParentescoServico(GrauParentescoServico grauParentescoServico) {
		this.grauParentescoServico = grauParentescoServico;
	}
}