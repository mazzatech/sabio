package com.sabio.dao;

import java.util.List;

import com.sabio.bean.Etnia;

public class EtniaDAOHibernate implements EtniaDAO {

	HibernateDAO<Etnia> hibernateDAO = null;

	public EtniaDAOHibernate() {
		hibernateDAO = new HibernateDAO<Etnia>(Etnia.class);
	}

	@Override
	public boolean inserir(Etnia etnia) throws Exception {

		boolean ok = false;

		try {
			hibernateDAO.add(etnia);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@Override
	public boolean alterar(Etnia etnia) throws Exception {

		boolean ok = false;
		
		try {
			hibernateDAO.update(etnia);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return ok;
	}

	@Override
	public boolean excluir(Etnia etnia) throws Exception {

		boolean ok = false;
		try {
			hibernateDAO.remove(etnia);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etnia> getSelecionar(String descricao) {
		String 	sql = "FROM Etnia WHERE codigoEtnia <> 0 ";

		if (!(descricao.isEmpty())) {
			sql += "AND descricao like '" + descricao + "%' ";  
		}

		sql += "ORDER BY descricao";		
 
		List<Etnia> lista = hibernateDAO.getSession().createQuery(sql).list();
		return lista;
	}

	@Override
	public Etnia getEtnia(int codigoEtnia) {
		
		Etnia etnia = hibernateDAO.get(codigoEtnia);
		return etnia;
	}

	@Override
	public List<Etnia> getListTodos() {
		
		List<Etnia> list = hibernateDAO.listAll();
		return list;
	}
}
