package com.sabio.controle.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sabio.bean.Pessoa;
import com.sabio.dao.DAOFactory;

@FacesConverter(value="convertePessoa", forClass=Pessoa.class) 
public class ConvertePessoa implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2.equals("0")){
			return new Pessoa();
		}
		Pessoa pessoa = DAOFactory.getPessoaDAO().getPessoa(Integer.valueOf(arg2));
		return pessoa;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(((Pessoa) arg2).getCodigoPessoa());
	}
}
