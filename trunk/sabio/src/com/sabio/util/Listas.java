package com.sabio.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

public class Listas {

	public Listas() {
	}

	public List<String> getEstados() {

		List<String> lista = new ArrayList<String>();
		lista.add("AC");
		lista.add("AL");
		lista.add("AM");
		lista.add("AP");
		lista.add("BA");
		lista.add("CE");
		lista.add("DF");
		lista.add("ES");
		lista.add("GO");
		lista.add("MA");
		lista.add("MG");
		lista.add("MS");
		lista.add("MT");
		lista.add("PA");
		lista.add("PB");
		lista.add("PE");
		lista.add("PI");
		lista.add("PR");
		lista.add("RJ");
		lista.add("RN");
		lista.add("RO");
		lista.add("RR");
		lista.add("RS");
		lista.add("SC");
		lista.add("SE");
		lista.add("SP");
		lista.add("TO");

		return lista;
	}

	public List<String> getNacionalidade(){
		List<String> lista = new ArrayList<String>();
		lista.add("Alemanha");
		lista.add("Argentina");
		lista.add("Bélgica");
		lista.add("Brasil");
		lista.add("Canadá");
		lista.add("Chile");
		lista.add("Coréia");
		lista.add("Dinamarca");
		lista.add("Estados Unidos");
		lista.add("Estônia");
		lista.add("Finlândia");
		lista.add("França");
		lista.add("Hong Kong");
		lista.add("Irlanda");
		lista.add("Inglaterra");
		lista.add("Itália");
		lista.add("Japão");
		lista.add("Malásia");
		lista.add("Malta");
		lista.add("Noruega");
		lista.add("Países Baixos");
		lista.add("Singapura");
		lista.add("Suécia");
		lista.add("Taiwan");
		lista.add("Tailândia");
		lista.add("Thecolosváquia");
		lista.add("Uruguai");
		
		return lista;
	}

	public List<String> getEstadoCivil(){
		List<String> lista = new ArrayList<String>();
		lista.add("Solteiro");
		lista.add("Casado");
		lista.add("Viúvo");
		lista.add("Divorciado");
		lista.add("Separado");
		lista.add("Outros");
		return lista;
	}
	
	public List<String> getTurno(){
		List<String> lista = new ArrayList<String>();
		lista.add("D");
		lista.add("M");
		lista.add("N");
		lista.add("V");
		return lista;
	}

	public List<SelectItem> getTipoCurso(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(null,"selecione"));
		lista.add(new SelectItem(1,"Garduação"));
		lista.add(new SelectItem(2,"Pos-Graduacao"));

		return lista;
	}

	public List<String> getPeriodosGraduacao(){
		List<String> lista = new ArrayList<String>();
		lista.add("0");
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		lista.add("5");
		lista.add("6");
		lista.add("7");
		lista.add("8");
		lista.add("9");
		lista.add("10");
		lista.add("11");
		lista.add("12");
		lista.add("13");
		lista.add("14");
		lista.add("15");
		lista.add("16");
		lista.add("17");
		lista.add("18");
		lista.add("19");
		lista.add("20");
		lista.add("21");
		lista.add("22");
		lista.add("23");
		lista.add("24");
		lista.add("25");
		lista.add("26");
		lista.add("27");
		lista.add("28");
		lista.add("29");
		lista.add("30");
		lista.add("31");
		lista.add("32");
		lista.add("33");
		lista.add("34");
		lista.add("35");
		lista.add("36");
		return lista;
	}	

	public List<String> getPeles(){
			List<String> lista = new ArrayList<String>();
			lista.add("N&atilde;o declarada");
			lista.add("Branca");
			lista.add("Preta");
			lista.add("Parda");
			lista.add("Amarela");
			lista.add("Ind&iacute;gena");
			return lista;
	   }	
	   
	public List<String> getDeficiencias() {

		List<String> lista = new ArrayList<String>();
		lista.add("N&atilde;o declarada");
		lista.add("Cegueira");
		lista.add("Baixa");
		lista.add("vis&atilde;o");
		lista.add("Surdez");
		lista.add("Auditiva");
		lista.add("Física");
		lista.add("Surdocegueira");
		lista.add("M&uacute;ltipla");
		lista.add("Mental");
		return lista;

	}	   
	
	public List<String> getSexos(){
		List<String> lista = new ArrayList<String>();
		lista.add("Masculino");
		lista.add("Feminino");
		return lista;
	}
	
	public List<SelectItem> getTurnos(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(null,"selecione"));
		lista.add(new SelectItem("D","Diurno"));
		lista.add(new SelectItem("M","Matutino"));
		lista.add(new SelectItem("N","Noturno"));
		lista.add(new SelectItem("V","Vespertino"));

		return lista;
	}

	@SuppressWarnings({ "rawtypes" })
	public Map getStatusHistorico(){
		Map<String, String> mapa = new HashMap<String, String>();  
		mapa.put("NCUR","Não Cursou");
		mapa.put("TRC","Trancado");
		mapa.put("REM","Reprovado por média");
		mapa.put("REF","Reprovado por falta");
		mapa.put("CDO","Cursando");
		mapa.put("TRF","Transferência");
	    mapa.put("DES","Desistente");
	    mapa.put("NMAT","Não matriculado");
		mapa.put("CANC","Matricula Cancelada");
		return mapa;
		
	}
	
	public List<String>getTiposNota(){
		List<String> lista = new ArrayList<String>();
		lista.add("Média");
		lista.add("Frequencia");
		lista.add("Sem Nota");
		return lista;
		
	}
	
	public List<String>getTiposDisciplina(){
		List<String> lista = new ArrayList<String>();
		lista.add("Teórica");
		lista.add("Pratica");
		return lista;
		
	}
	
	public List<String>getDias(){
		List<String> lista = new ArrayList<String>();
		lista.add("");
		lista.add("Segunda");
		lista.add("Terça");
		lista.add("Quarta");
		lista.add("Quinta");
		lista.add("Sexta");
		lista.add("Sábado");
		return lista;
	}

	public List<String>getAulas(){
		List<String> lista = new ArrayList<String>();
		lista.add("");
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		lista.add("5");
		return lista;
	}

	public List<String>getNotas(){

		List<String> lista = new ArrayList<String>();
		lista.add("faltou");
		lista.add("0.0");
		lista.add("0.5");
		lista.add("1.0");
		lista.add("1.5");
		lista.add("2.0");
		lista.add("2.5");
		lista.add("3.0");
		lista.add("3.5");
		lista.add("4.0");
		lista.add("4.5");
		lista.add("5.0");
		lista.add("5.5");
		lista.add("6.0");
		lista.add("6.5");
		lista.add("7.0");
		lista.add("7.5");
		lista.add("8.0");
		lista.add("8.5");
		lista.add("9.0");
		lista.add("9.5");
		lista.add("10.0");
		
		return lista;
	
	}
	
	public List<SelectItem>getValorFaltas(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		for (int i = 0; i < 31; i++) {
			lista.add(new SelectItem(i, String.valueOf(i)));
		}
		return lista;
	}
	
	public List<SelectItem>getValorNotas(){

		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(-1.0, "faltou"));
		lista.add(new SelectItem(0.0,"0.0"));
		lista.add(new SelectItem(0.5,"0.5"));
		lista.add(new SelectItem(1.0,"1.0"));
		lista.add(new SelectItem(1.5,"1.5"));
		lista.add(new SelectItem(2.0,"2.0"));
		lista.add(new SelectItem(2.5,"2.5"));
		lista.add(new SelectItem(3.0,"3.0"));
		lista.add(new SelectItem(3.5,"3.5"));
		lista.add(new SelectItem(4.0,"4.0"));
		lista.add(new SelectItem(4.5,"4.5"));
		lista.add(new SelectItem(5.0,"5.0"));
		lista.add(new SelectItem(5.5,"5.5"));
		lista.add(new SelectItem(6.0,"6.0"));
		lista.add(new SelectItem(6.5,"6.5"));
		lista.add(new SelectItem(7.0,"7.0"));
		lista.add(new SelectItem(7.5,"7.5"));
		lista.add(new SelectItem(8.0,"8.0"));
		lista.add(new SelectItem(8.5,"8.5"));
		lista.add(new SelectItem(9.0,"9.0"));
		lista.add(new SelectItem(9.5,"9.5"));
		lista.add(new SelectItem(10.0,"10.0"));
		
		return lista;
	
	}
	
	public List<SelectItem> getMeses(){
		List<SelectItem> listaMeses = new ArrayList<SelectItem>();
		listaMeses.add(new SelectItem(null,"selecione"));
		listaMeses.add(new SelectItem(1,"Janeiro"));
		listaMeses.add(new SelectItem(2,"Fevereiro"));
		listaMeses.add(new SelectItem(3,"Março"));
		listaMeses.add(new SelectItem(4,"Abril"));
		listaMeses.add(new SelectItem(5,"Maio"));
		listaMeses.add(new SelectItem(6,"Junho"));
		listaMeses.add(new SelectItem(7,"Julho"));
		listaMeses.add(new SelectItem(8,"Agosto"));
		listaMeses.add(new SelectItem(9,"Setembro"));
		listaMeses.add(new SelectItem(10,"Outubro"));
		listaMeses.add(new SelectItem(11,"Novembro"));
		listaMeses.add(new SelectItem(12,"Dezembro"));

		return listaMeses;
	}
	
	public List<SelectItem> getPeriodos(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(null,"selecione"));

		for(int i = 1; i<=14; i++ ){
			lista.add(new SelectItem(i, ""+i+"º"));
		}
		return lista;
	}

	public List<SelectItem> getTipoDesconto(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(null,"selecione"));
		lista.add(new SelectItem("D","Dinheiro"));
		lista.add(new SelectItem("P","Porcentagem"));

		return lista;
	}
}
