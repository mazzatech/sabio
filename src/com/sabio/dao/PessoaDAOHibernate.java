package com.sabio.dao;

import java.util.List;

import com.sabio.bean.Pessoa;

public class PessoaDAOHibernate implements PessoaDAO {
	HibernateDAO<Pessoa> hibernateDAO = null;

	public PessoaDAOHibernate() {
		hibernateDAO = new HibernateDAO<Pessoa>(Pessoa.class);
	}

	@Override
	public boolean inserir(Pessoa pessoa) throws Exception {

		boolean ok = false;

		try {
			hibernateDAO.add(pessoa);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@Override
	public boolean alterar(Pessoa pessoa) throws Exception {

		boolean ok = false;
		
		try {
			hibernateDAO.update(pessoa);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return ok;
	}

	@Override
	public boolean excluir(Pessoa pessoa) throws Exception {

		boolean ok = false;
		try {
			hibernateDAO.remove(pessoa);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> getSelecionar(String CPF, String RG, String nome) {

		List<Pessoa> lista = hibernateDAO.getSession().createQuery("").list();
		return lista;
	}

	@Override
	public Pessoa getPessoa(int codigoPessoa) {
		
		Pessoa pessoa = hibernateDAO.get(codigoPessoa);
		return pessoa;
	}

	@Override
	public List<Pessoa> getListTodos() {
		
		List<Pessoa> list = hibernateDAO.listAll();
		return list;
	}
}
