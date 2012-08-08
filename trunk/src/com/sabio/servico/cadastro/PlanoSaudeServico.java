package com.sabio.servico.cadastro;

import java.io.Serializable;
import java.util.List;

import com.sabio.bean.PlanoSaude;
import com.sabio.dao.DAOFactory;
import com.sabio.servico.validador.GeraMensagem;
import com.sabio.servico.validador.ValidadorFactory;
import com.sabio.servico.validador.Validar;

public class PlanoSaudeServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PlanoSaude planoSaude;
	private String mensagem;

	public PlanoSaudeServico() {
	}

	public List<PlanoSaude> pesquisar(String pesquisaDescricao){
		return DAOFactory.getPlanoSaudeDAO().getSelecionar(pesquisaDescricao);
	}

	/**
	 * Verifica se pode grava o PlanoSaude se sim chama incluir
	 * 
	 * @param aluno
	 * @throws Exception
	 */
	public void gravar(PlanoSaude planoSaude) throws Exception{
		this.planoSaude = planoSaude;
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
		validador.validar(planoSaude);
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
			if(planoSaude.getCodigoPlanoSaude() == 0 ){
				DAOFactory.getPlanoSaudeDAO().inserir(planoSaude);
			}else{
				DAOFactory.getPlanoSaudeDAO().alterar(planoSaude);
			}
		} catch (Exception e) {
			ok = false;
			mensagem = "erro: "+e.getMessage();
		}
		

		return ok;
	}

	public void excluir(PlanoSaude planoSaude) throws Exception{
		try{
			DAOFactory.getPlanoSaudeDAO().excluir(planoSaude);
		}catch (Exception e){
			throw new Exception("Erro na exclus‹o de Aluno.");  
		}
	}

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}
	
	public List<PlanoSaude> getListTodos(){
		return DAOFactory.getPlanoSaudeDAO().getListTodos();
	}
}
