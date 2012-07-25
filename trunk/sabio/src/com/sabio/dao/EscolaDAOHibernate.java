package com.sabio.dao;


import java.util.List;


import com.sabio.bean.Escola;


public class EscolaDAOHibernate implements EscolaDAO {

	HibernateDAO<Escola> hibernateDAO = null;

	public EscolaDAOHibernate() {
		hibernateDAO = new HibernateDAO<Escola>(Escola.class);
	}

	@Override
	public boolean inserir(Escola escola) throws Exception {

		boolean ok = false;

		try {
			hibernateDAO.add(escola);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@Override
	public boolean alterar(Escola escola) throws Exception {

		boolean ok = false;
		
		try {
			hibernateDAO.update(escola);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return ok;
	}

	@Override
	public boolean excluir(Escola escola) throws Exception {

		boolean ok = false;
		try {
			hibernateDAO.remove(escola);
			ok = true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 

		return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Escola> getSelecionar(String CNPJ,String descricao, String sigla) {
		String 	sql = "FROM Escola WHERE codigoEscola <> 0 ";

		if (!(descricao.isEmpty())) {
			sql += "AND descricao like '" + descricao + "%' ";  
		}
		
		if (!(CNPJ.isEmpty())) {
			sql += "AND CNPJ = '" + CNPJ + "' ";  
		}
	
		if (!(sigla.isEmpty())) {
			sql += "AND sigla like '" + sigla + "%' ";
  
		}
		
		sql += "ORDER BY descricao";		
 
		List<Escola> lista = hibernateDAO.getSession().createQuery(sql).list();
		return lista;
	}

	@Override
	public Escola getEscola(int codigoEscola) {
		
		Escola escola = hibernateDAO.get(codigoEscola);
		return escola;
	}

	@Override
	public List<Escola> getListTodos() {
		
		List<Escola> list = hibernateDAO.listAll();
		return list;
	}


}
