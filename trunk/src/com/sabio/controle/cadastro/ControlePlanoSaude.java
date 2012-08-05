package com.sabio.controle.cadastro;

import java.io.IOException;
import java.io.Serializable;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;

import com.sabio.bean.PlanoSaude;
import com.sabio.controle.ControleSession;
import com.sabio.servico.cadastro.PlanoSaudeServico;

@ManagedBean
@SessionScoped
public class ControlePlanoSaude extends ControleSession implements Serializable{
	private static final long serialVersionUID = -7517459978933604163L;
	private PlanoSaude planoSaude;
	private List<PlanoSaude> lista;
	private String pesquisaDescricao;
	private String mensagem;
	private String retorno = "cadastro";
	private PlanoSaudeServico planoSaudeServico;
	
	public ControlePlanoSaude() {
		super("controlePlanoSaude");
	}

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
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
		planoSaude = new PlanoSaude();
		return "cadastro";
	}

	public String manutencao(){
		return "manutencao";
	}

	public void pesquisar(){
		setLista(getPlanoSaudeServico().pesquisar(pesquisaDescricao));
	}

	public String gravar(){

		try {
			getPlanoSaudeServico().gravar(planoSaude);
			if(getPlanoSaude().getCodigoPlanoSaude() == 0 ){
				setMensagem("Cadastro com Sucesso");
				retorno = "manutencao";
			}else{
				planoSaude = null;
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
			getPlanoSaudeServico().excluir(planoSaude);
		} catch (Exception e) {
			enviaMensagem(e.getMessage(), ControleSession.ERROR);
		}
		pesquisar();
		return "manutencao";
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	public List<PlanoSaude> getLista() {
		return lista;
	}

	public void setLista(List<PlanoSaude> lista) {
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

	public PlanoSaudeServico getPlanoSaudeServico() {
		if(planoSaudeServico == null){
			planoSaudeServico = new PlanoSaudeServico();
		}
		return planoSaudeServico;
	}

	public void setPlanoSaudeServico(PlanoSaudeServico planoSaudeServico) {
		this.planoSaudeServico = planoSaudeServico;
	}
}