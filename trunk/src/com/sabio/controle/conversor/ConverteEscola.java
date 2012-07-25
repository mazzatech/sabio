package com.sabio.controle.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sabio.bean.Escola;
import com.sabio.dao.DAOFactory;



@FacesConverter(value="converteEscola", forClass=Escola.class) 
public class ConverteEscola implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2.equals("0")){
			return new Escola();
		}
		Escola escola = DAOFactory.getEscolaDAO().getEscola(Integer.valueOf(arg2));
		return escola;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((Escola) arg2).getCodigoEscola());
	}

}
