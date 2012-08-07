package com.sabio.controle.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sabio.bean.PlanoSaude;
import com.sabio.dao.DAOFactory;

@FacesConverter(value="convertePlanoSaude", forClass=PlanoSaude.class) 
public class ConvertePlanoSaude implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2.equals("0")){
			return new PlanoSaude();
		}
		PlanoSaude planoSaude = DAOFactory.getPlanoSaudeDAO().getPlanoSaude(Integer.valueOf(arg2));
		return planoSaude;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((PlanoSaude) arg2).getCodigoPlanoSaude());
	}
}
