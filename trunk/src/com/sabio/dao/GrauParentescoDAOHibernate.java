package com.sabio.dao;

import java.util.List;

import com.sabio.bean.GrauParentesco;

public class GrauParentescoDAOHibernate implements GrauParentescoDAO {

	HibernateDAO<GrauParentesco> hibernateDAO = null;

	public GrauParentescoDAOHibernate() {
		hibernateDAO = new HibernateDAO<GrauParentesco>(GrauParentesco.class);
	}

	@Override
	public boolean inserir(GrauParentesco grauParentesco) throws Exception {

		boolean ok = false;

		try {
			hibernateDAO.add(grauParentesco);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@Override
	public boolean alterar(GrauParentesco grauParentesco) throws Exception {

		boolean ok = false;
		
		try {
			hibernateDAO.update(grauParentesco);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return ok;
	}

	@Override
	public boolean excluir(GrauParentesco grauParentesco) throws Exception {

		boolean ok = false;
		try {
			hibernateDAO.remove(grauParentesco);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GrauParentesco> getSelecionar(String descricao) {
		String 	sql = "FROM GrauParentesco WHERE codigoGrauParentesco <> 0 ";

		if (!(descricao.isEmpty())) {
			sql += "AND descricao like '" + descricao + "%' ";  
		}

		sql += "ORDER BY descricao";		
 
		List<GrauParentesco> lista = hibernateDAO.getSession().createQuery(sql).list();
		return lista;
	}

	@Override
	public GrauParentesco getGrauParentesco(int codigoGrauParentesco) {
		
		GrauParentesco grauParentesco = hibernateDAO.get(codigoGrauParentesco);
		return grauParentesco;
	}

	@Override
	public List<GrauParentesco> getListTodos() {
		
		List<GrauParentesco> list = hibernateDAO.listAll();
		return list;
	}
}
