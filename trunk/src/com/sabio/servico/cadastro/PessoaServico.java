package com.sabio.servico.cadastro;

import java.util.List;

import com.sabio.bean.Pessoa;
import com.sabio.dao.DAOFactory;
import com.sabio.servico.validador.GeraMensagem;
import com.sabio.servico.validador.ValidadorFactory;
import com.sabio.servico.validador.Validar;

public class PessoaServico {

	private Pessoa pessoa;
	private String mensagem;

	public PessoaServico() {
	}

	public List<Pessoa> pesquisar(String CPF, String RG, String nome){
		return DAOFactory.getPessoaDAO().getSelecionar(CPF, RG, nome);
	}

	/**
	 * Verifica se pode grava o Pessoa se sim chama incluir
	 * 
	 * @param aluno
	 * @throws Exception
	 */
	public void gravar(Pessoa pessoa) throws Exception{
		this.pessoa = pessoa;
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
		validador.validar(pessoa);
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
			if(pessoa.getCodigoPessoa() == 0 ){
				DAOFactory.getPessoaDAO().inserir(pessoa);
			}else{
				DAOFactory.getPessoaDAO().alterar(pessoa);
			}
		} catch (Exception e) {
			ok = false;
			mensagem = "erro: "+e.getMessage();
		}
		

		return ok;
	}

	public void excluir(Pessoa pessoa) throws Exception{
		try{
			DAOFactory.getPessoaDAO().excluir(pessoa);
		}catch (Exception e){
			throw new Exception("Erro na exclus‹o de Aluno.");  
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
