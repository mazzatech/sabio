package com.sabio.dao;

import java.util.List;

import com.sabio.bean.Pessoa;

public interface PessoaDAO {
	/**
	 * Insere uma etnia no banco de dados
	 * @param etnia
	 * @return true se obeter sucesso, ou false se falhar.
	 * @throws Exception 
	 * @throws Exception
	 */
	public boolean inserir(Pessoa pessoa) throws  Exception ;
	
	/**
	 * Altera uma etnia no banco de dados
	 * @param etnia
	 * @return
	 * @throws Exception
	 */
	public boolean alterar(Pessoa pessoa) throws  Exception;
	
	/**
	 * Excluir uma etnia no banco de dados
	 * @param etnia
	 * @return
	 * @throws ExcluirEntidadeException 
	 * @throws Exception
	 */
	public boolean excluir(Pessoa pessoa) throws Exception;
	
	/**
	 * Retorna uma Lista (List) com todas as etnias, começando com o parametro CNPJ ou descrição ou sigla.
	 * Se campos forem branco, lista todas as etnias
	 * @param CNPJ
	 * @param descrição
	 * @param sigla
	 * @return List
	 */
	public List<Pessoa> getSelecionar(String CPF, String RG, String nome);
	
	/**
	 * Retorna uma instacia de Pessoa com o codigoPessoa passado no parametros
	 * @param codigoPessoa
	 * @return Pessoa
	 */
	public Pessoa getPessoa(int codigoPessoa);
	
	/**
	 * Retorna uma lista de todas as etnias
	 * @return List
	 */
	public List<Pessoa> getListTodos();
}
