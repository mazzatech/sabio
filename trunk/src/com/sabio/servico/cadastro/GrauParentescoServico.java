package com.sabio.servico.cadastro;

import java.util.List;

import com.sabio.bean.GrauParentesco;
import com.sabio.dao.DAOFactory;
import com.sabio.servico.validador.GeraMensagem;
import com.sabio.servico.validador.ValidadorFactory;
import com.sabio.servico.validador.Validar;

public class GrauParentescoServico {

	private GrauParentesco grauParentesco;
	private String mensagem;

	public GrauParentescoServico() {
	}

	public List<GrauParentesco> pesquisar(String pesquisaDescricao){
		return DAOFactory.getGrauParentescoDAO().getSelecionar(pesquisaDescricao);
	}

	/**
	 * Verifica se pode grava o GrauParentesco se sim chama incluir
	 * 
	 * @param aluno
	 * @throws Exception
	 */
	public void gravar(GrauParentesco grauParentesco) throws Exception{
		this.grauParentesco = grauParentesco;
		if (!validaObjeto()){
			throw new Exception(mensagem);  
		}
		
		if (!incluir()){
			throw new Exception(mensagem);  
		}
	}

	/**
	 * Valida o objeto antes de gravar
	 * @return
	 */
	private boolean validaObjeto() {
		boolean ok = true;
				
		Validar validador = ValidadorFactory.getValidador();
		validador.validar(grauParentesco);
		String[] mensagens = validador.getMensagensValidacao();
		mensagem = GeraMensagem.getMensagem(mensagens);

		if (!validador.isOk()){
			ok = false;
		}
	
		return ok;
	}

	/**
	 * grava o aluno
	 * 
	 * @return
	 */
	private boolean incluir(){
		boolean ok = true;

		try {
			if(grauParentesco.getCodigoGrauParentesco() == 0 ){
				DAOFactory.getGrauParentescoDAO().inserir(grauParentesco);
			}else{
				DAOFactory.getGrauParentescoDAO().alterar(grauParentesco);
			}
		} catch (Exception e) {
			ok = false;
			mensagem = "erro: "+e.getMessage();
		}
		

		return ok;
	}

	public void excluir(GrauParentesco grauParentesco) throws Exception{
		try{
			DAOFactory.getGrauParentescoDAO().excluir(grauParentesco);
		}catch (Exception e){
			throw new Exception("Erro na exclus‹o de Aluno.");  
		}
	}

	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
}
