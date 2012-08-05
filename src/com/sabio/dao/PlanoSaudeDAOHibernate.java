package com.sabio.dao;

import java.util.List;

import com.sabio.bean.PlanoSaude;

public class PlanoSaudeDAOHibernate implements PlanoSaudeDAO {

	HibernateDAO<PlanoSaude> hibernateDAO = null;

	public PlanoSaudeDAOHibernate() {
		hibernateDAO = new HibernateDAO<PlanoSaude>(PlanoSaude.class);
	}

	@Override
	public boolean inserir(PlanoSaude planoSaude) throws Exception {

		boolean ok = false;

		try {
			hibernateDAO.add(planoSaude);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@Override
	public boolean alterar(PlanoSaude planoSaude) throws Exception {

		boolean ok = false;
		
		try {
			hibernateDAO.update(planoSaude);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return ok;
	}

	@Override
	public boolean excluir(PlanoSaude planoSaude) throws Exception {

		boolean ok = false;
		try {
			hibernateDAO.remove(planoSaude);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanoSaude> getSelecionar(String descricao) {
		String 	sql = "FROM PlanoSaude WHERE codigoPlanoSaude <> 0 ";

		if (!(descricao.isEmpty())) {
			sql += "AND descricao like '" + descricao + "%' ";  
		}

		sql += "ORDER BY descricao";		
 
		List<PlanoSaude> lista = hibernateDAO.getSession().createQuery(sql).list();
		return lista;
	}

	@Override
	public PlanoSaude getPlanoSaude(int codigoPlanoSaude) {
		
		PlanoSaude planoSaude = hibernateDAO.get(codigoPlanoSaude);
		return planoSaude;
	}

	@Override
	public List<PlanoSaude> getListTodos() {
		
		List<PlanoSaude> list = hibernateDAO.listAll();
		return list;
	}
}
