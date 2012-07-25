package com.sabio.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
/**
 * Classe responsavel para verificar se a data é um dia útil
 * @author amorim
 *
 */
public class DiaUtil {

	private Date data;
	
	public DiaUtil(){
		
	}

	public DiaUtil(Date data){
		this.data = data;
	}

	/**
	 * valida a data
	 * @return
	 */
	public boolean isValido() {
		if (this.data == null){
			return false;
		}
		if (isFinalSemana(this.data) || isFeriado(this.data)){
			return false;
		}
		return true;
	}

	private boolean isFinalSemana(Date data){
		Calendar cal = Calendar.getInstance();   
		cal.setTime(data);   
		int dia = cal.get(Calendar.DAY_OF_WEEK);   
		if (dia == Calendar.SATURDAY || dia == Calendar.SUNDAY ){
			return true;
		}
		return false;
	}

	public static Date getProximoDiaUtil(Date data){
		DiaUtil diaUtil = new DiaUtil(data);
		while ( ! diaUtil.isValido() ) {
			data = DiaUtil.somaDias(data, 1);
			diaUtil.setData(data);
		}
		return data;
	}
	
	@SuppressWarnings("static-access")
	public boolean isFeriado(Date data){
		Calendar cal = Calendar.getInstance();   
		cal.setTime(data);
		int ano = cal.YEAR;

		int a = ano % 19;
		int b = ano / 100;
		int c = ano % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int l = (32 + (2 * e) + (2 * i) - h - k) % 7;
		int m = (a + (11 * h) + (22 * l)) / 451;
		int p = (h + l - (7 * m) + 114) / 31;
		int q = (h + l - (7 * m) + 114) % 31;
		int dia = q + 1;
		int mes = p;

		String dta1 = String.format("%02d", dia) + "/" + String.format("%02d", mes) + "/" + ano;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dtPascoa = null;
		try {
			dtPascoa = simpleDateFormat.parse(dta1);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		/*
		 * Domingo de Carnaval
		 */
		cal.setTime(dtPascoa);
		cal.add(Calendar.DAY_OF_MONTH, -49); 
		if (cal.getTime() == data){
			return true;
		}

		/*
		 * Segunda de Carnaval
		 */
		cal.add(Calendar.DAY_OF_MONTH, -48); 
		if (cal.getTime() == data){
			return true;
		}

		/*
		 * Terça de Carnaval
		 */
		cal.add(Calendar.DAY_OF_MONTH, -47); 
		if (cal.getTime() == data){
			return true;
		}

		/*
		 * Quarta de Carnaval
		 */
		cal.add(Calendar.DAY_OF_MONTH, -46); 
		if (cal.getTime() == data){
			return true;
		}

		/*
		 * Domingo de Ramos
		 */
		cal.add(Calendar.DAY_OF_MONTH, -7); 
		if (cal.getTime() == data){
			return true;
		}

		/*
		 * Sexta da paixão
		 */
		cal.add(Calendar.DAY_OF_MONTH, -2); 
		if (cal.getTime() == data){
			return true;
		}

		/*
		 * Corpus Christi
		 */
		cal.add(Calendar.DAY_OF_MONTH, -2); 
		if (cal.getTime() == data){
			return true;
		}

		return false;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Método que retorna a data acrescida aos dias
	 * @param data1
	 * @param dias
	 * @return
	 */
	public static Date somaDias (Date data1, int dias){
		DateTime d1 = new DateTime(data1); 
		data1 = d1.plusDays(dias).toDate();
		return data1;
	}
	
	public static int dia(Date data1){
		DateTime d1 = new DateTime(data1);
		return d1.getDayOfMonth();
	}
	
	public static int mes(Date data1){
		DateTime d1 = new DateTime(data1);
		return d1.getMonthOfYear();
	}
	
	public static int ano(Date data1){
		DateTime d1 = new DateTime(data1);
		return d1.getYear();
	}
	
	/**
	 * Método que retorna a diferença em dias entre duas datas / joda.org
	 * @param data2
	 * @return
	 */  
	public static int dataDiff(Date data1, Date data2){
		DateTime d1 = new DateTime(data1);   
		DateTime d2 = new DateTime(data2);   
		Days days = Days.daysBetween(d1, d2);
		
		return days.getDays();
		
	}
	
	public static Date somaMes(Date data1, int meses){
		DateTime d1 = new DateTime(data1);
		return d1.plusMonths(meses).toDate();
	}

	
	public static Date ajustaDatas(Date data, int mesesSoma){
		int dias = 0;
		boolean bOk = false;

		DiaUtil diaUtil = new DiaUtil();
		Date d = DiaUtil.somaMes(data, mesesSoma);

		while(!bOk){
			if(diaUtil.isFeriado(d)){
				dias++;
				d = DiaUtil.somaDias(data, dias);
			}else{
				bOk = true;
			}
		}
		return d;	
	}	
}
