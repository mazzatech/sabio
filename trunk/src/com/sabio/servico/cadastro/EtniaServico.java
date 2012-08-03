package com.sabio.servico.cadastro;

import java.util.List;

import com.sabio.bean.Etnia;
import com.sabio.dao.DAOFactory;
import com.sabio.servico.validador.GeraMensagem;
import com.sabio.servico.validador.ValidadorFactory;
import com.sabio.servico.validador.Validar;

public class EtniaServico {

	private Etnia etnia;
	private String mensagem;

	public EtniaServico() {
	}

	public List<Etnia> pesquisar(String pesquisaDescricao){
		return DAOFactory.getEtniaDAO().getSelecionar(pesquisaDescricao);
	}

	/**
	 * Verifica se pode grava o Etnia se sim chama incluir
	 * 
	 * @param aluno
	 * @throws Exception
	 */
	public void gravar(Etnia etnia) throws Exception{
		this.etnia = etnia;
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
		validador.validar(etnia);
		String[] mensagens = validador.getMensagensValidacao();
		mensagem = GeraMensagem.getMensagem(mensagens);

		if (validador.isOk()){
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
			if(etnia.getCodigoEtnia() == 0 ){
				DAOFactory.getEtniaDAO().inserir(etnia);
			}else{
				DAOFactory.getEtniaDAO().alterar(etnia);
			}
		} catch (Exception e) {
			ok = false;
			mensagem = "erro: "+e.getMessage();
		}
		

		return ok;
	}

	public void excluir(Etnia etnia) throws Exception{
		try{
			DAOFactory.getEtniaDAO().excluir(etnia);
		}catch (Exception e){
			throw new Exception("Erro na exclus‹o de Aluno.");  
		}
	}

	public Etnia getEtnia() {
		return etnia;
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}
}
