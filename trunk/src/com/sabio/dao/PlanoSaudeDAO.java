package com.sabio.dao;

import java.util.List;

import com.sabio.bean.PlanoSaude;


public interface PlanoSaudeDAO {
	
	/**
	 * Insere uma planoSaude no banco de dados
	 * @param planoSaude
	 * @return true se obeter sucesso, ou false se falhar.
	 * @throws Exception 
	 * @throws Exception
	 */
	public boolean inserir(PlanoSaude planoSaude) throws  Exception ;
	
	/**
	 * Altera uma planoSaude no banco de dados
	 * @param planoSaude
	 * @return
	 * @throws Exception
	 */
	public boolean alterar(PlanoSaude planoSaude) throws  Exception;
	
	/**
	 * Excluir uma planoSaude no banco de dados
	 * @param planoSaude
	 * @return
	 * @throws ExcluirEntidadeException 
	 * @throws Exception
	 */
	public boolean excluir(PlanoSaude planoSaude) throws Exception;
	
	/**
	 * Retorna uma Lista (List) com todas as planoSaudes, começando com o parametro CNPJ ou descrição ou sigla.
	 * Se campos forem branco, lista todas as planoSaudes
	 * @param CNPJ
	 * @param descrição
	 * @param sigla
	 * @return List
	 */
	public List<PlanoSaude> getSelecionar(String descricao);
	
	/**
	 * Retorna uma instacia de PlanoSaude com o codigoPlanoSaude passado no parametros
	 * @param codigoPlanoSaude
	 * @return PlanoSaude
	 */
	public PlanoSaude getPlanoSaude(int codigoPlanoSaude);
	
	/**
	 * Retorna uma lista de todas as planoSaudes
	 * @return List
	 */
	public List<PlanoSaude> getListTodos();

	
}
