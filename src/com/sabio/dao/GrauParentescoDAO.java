package com.sabio.dao;

import java.util.List;

import com.sabio.bean.GrauParentesco;


public interface GrauParentescoDAO {
	
	/**
	 * Insere uma grauParentesco no banco de dados
	 * @param grauParentesco
	 * @return true se obeter sucesso, ou false se falhar.
	 * @throws Exception 
	 * @throws Exception
	 */
	public boolean inserir(GrauParentesco grauParentesco) throws  Exception ;
	
	/**
	 * Altera uma grauParentesco no banco de dados
	 * @param grauParentesco
	 * @return
	 * @throws Exception
	 */
	public boolean alterar(GrauParentesco grauParentesco) throws  Exception;
	
	/**
	 * Excluir uma grauParentesco no banco de dados
	 * @param grauParentesco
	 * @return
	 * @throws ExcluirEntidadeException 
	 * @throws Exception
	 */
	public boolean excluir(GrauParentesco grauParentesco) throws Exception;
	
	/**
	 * Retorna uma Lista (List) com todas as grauParentescos, começando com o parametro CNPJ ou descrição ou sigla.
	 * Se campos forem branco, lista todas as grauParentescos
	 * @param CNPJ
	 * @param descrição
	 * @param sigla
	 * @return List
	 */
	public List<GrauParentesco> getSelecionar(String descricao);
	
	/**
	 * Retorna uma instacia de GrauParentesco com o codigoGrauParentesco passado no parametros
	 * @param codigoGrauParentesco
	 * @return GrauParentesco
	 */
	public GrauParentesco getGrauParentesco(int codigoGrauParentesco);
	
	/**
	 * Retorna uma lista de todas as grauParentescos
	 * @return List
	 */
	public List<GrauParentesco> getListTodos();

	
}
