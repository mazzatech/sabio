package com.sabio.dao;

import java.util.List;

import com.sabio.bean.Etnia;


public interface EtniaDAO {
	
	/**
	 * Insere uma etnia no banco de dados
	 * @param etnia
	 * @return true se obeter sucesso, ou false se falhar.
	 * @throws Exception 
	 * @throws Exception
	 */
	public boolean inserir(Etnia etnia) throws  Exception ;
	
	/**
	 * Altera uma etnia no banco de dados
	 * @param etnia
	 * @return
	 * @throws Exception
	 */
	public boolean alterar(Etnia etnia) throws  Exception;
	
	/**
	 * Excluir uma etnia no banco de dados
	 * @param etnia
	 * @return
	 * @throws ExcluirEntidadeException 
	 * @throws Exception
	 */
	public boolean excluir(Etnia etnia) throws Exception;
	
	/**
	 * Retorna uma Lista (List) com todas as etnias, começando com o parametro CNPJ ou descrição ou sigla.
	 * Se campos forem branco, lista todas as etnias
	 * @param CNPJ
	 * @param descrição
	 * @param sigla
	 * @return List
	 */
	public List<Etnia> getSelecionar(String descricao);
	
	/**
	 * Retorna uma instacia de Etnia com o codigoEtnia passado no parametros
	 * @param codigoEtnia
	 * @return Etnia
	 */
	public Etnia getEtnia(int codigoEtnia);
	
	/**
	 * Retorna uma lista de todas as etnias
	 * @return List
	 */
	public List<Etnia> getListTodos();

	
}
