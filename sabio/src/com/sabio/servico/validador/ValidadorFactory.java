package com.sabio.servico.validador;

public class ValidadorFactory {

	
	public static Validar getValidador(){
		return new ValidacaoHibernate();
	}
	
	
}
