package com.sabio.servico.validador;

public class GeraMensagem {


	public static String getMensagem(String texto) {

		String mensagem = "";
		mensagem += "<br /> &nbsp;" + texto;

		return mensagem;
	}

	public static String getMensagem(String[] textos) {

		String mensagem = "";

		for (int i = 0; i < textos.length; i++) {
			mensagem += "<br /> &nbsp;" + textos[i];
		}
		return mensagem;
	}
	
	public static String getMensagemNormal(String[] textos) {

		String mensagem = "";

		for (int i = 0; i < textos.length; i++) {
			mensagem += "\n" + textos[i];
		}
		return mensagem;
	}	

}
