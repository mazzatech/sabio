package com.sabio.dao;

import java.util.List;

import com.sabio.bean.Escola;


public interface EscolaDAO {
	
	/**
	 * Insere uma escola no banco de dados
	 * @param escola
	 * @return true se obeter sucesso, ou false se falhar.
	 * @throws Exception 
	 * @throws Exception
	 */
	public boolean inserir(Escola escola) throws  Exception ;
	
	/**
	 * Altera uma escola no banco de dados
	 * @param escola
	 * @return
	 * @throws Exception
	 */
	public boolean alterar(Escola escola) throws  Exception;
	
	/**
	 * Excluir uma escola no banco de dados
	 * @param escola
	 * @return
	 * @throws ExcluirEntidadeException 
	 * @throws Exception
	 */
	public boolean excluir(Escola escola) throws Exception;
	
	/**
	 * Retorna uma Lista (List) com todas as escolas, começando com o parametro CNPJ ou descrição ou sigla.
	 * Se campos forem branco, lista todas as escolas
	 * @param CNPJ
	 * @param descrição
	 * @param sigla
	 * @return List
	 */
	public List<Escola> getSelecionar(String CNPJ,String descricao, String sigla);
	
	/**
	 * Retorna uma instacia de Escola com o codigoEscola passado no parametros
	 * @param codigoEscola
	 * @return Escola
	 */
	public Escola getEscola(int codigoEscola);
	
	/**
	 * Retorna uma lista de todas as escolas
	 * @return List
	 */
	public List<Escola> getListTodos();

	
}
