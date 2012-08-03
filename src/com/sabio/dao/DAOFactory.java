package com.sabio.dao;

public class DAOFactory {
	public static EscolaDAO getEscolaDAO(){
		return new EscolaDAOHibernate();
	}

	public static PessoaDAO getPessoaDAO(){
		return new PessoaDAOHibernate();
	}

	public static EtniaDAO getEtniaDAO(){
		return new EtniaDAOHibernate();
	}
}
