package com.sabio.controle;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.CloseEvent;

import com.fejal.seguranca.bean.Usuario;

public class ControleSession {
	
	private static final String[] CONTROLE_EXCLUSO = {"controleLogin"}; 
	private static ControleSession controleSession;
	public static final int INFO = 1;
	public static final int ERROR = 2;
	public static final int WARN = 3;
	public static final int FATAL = 4;
	public String retorno="";
	private Usuario usuario;
	
	public ControleSession(){
		
	}

	public ControleSession(String managed){
		removeSession(managed);
	}

	public static ControleSession getInstance(){
		if (controleSession==null){
			controleSession = new ControleSession();
		}
		return controleSession;
	}
	
	@SuppressWarnings("rawtypes")
	public void removeSession(String managed){

		Map  mp = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    Iterator it = mp.entrySet().iterator();

	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        if(		(pairs.getKey().toString().length() > 8) && 
	        		(pairs.getKey().toString().substring(0,8).equals("controle"))){
	        	
	        	for (int j = 0; j < CONTROLE_EXCLUSO.length; j++) {
		        	if(	(!CONTROLE_EXCLUSO[j].equals(pairs.getKey().toString())) && 
		        		(!pairs.getKey().toString().equals(managed))){

		        		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(pairs.getKey().toString());
		        	}
				}
	        }
	    }
	}
	
	public void enviaMensagem(String mensagem, int tipo){
		switch (tipo) {
		case INFO: 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem, ""));
			break;
		case ERROR: 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem, ""));
			break;
		case WARN: 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,mensagem, ""));
			break;
		case FATAL: 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,mensagem, ""));
			break;
		}
	}

	public void retorna(CloseEvent event) throws IOException {
		FacesContext faces = FacesContext.getCurrentInstance();   
		ExternalContext context = faces.getExternalContext();   
		context.redirect(retorno+".jsf");
	}


	public Usuario getUsuario() {
        HttpSession session = null;
        session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
        usuario = (Usuario) session.getAttribute( "usr" );
		return usuario;
	}

	public String getContextPath() {  
		 FacesContext fc = FacesContext.getCurrentInstance();  
		 ServletContext sc = (ServletContext) fc.getExternalContext().getContext();  
		 return sc.getRealPath(File.separator); 
	}
	
	public String getIpServer(){
		FacesContext fc = FacesContext.getCurrentInstance();  
		ServletRequest servletRequest = (ServletRequest)fc.getExternalContext().getRequest();
		String ip = servletRequest.getLocalAddr(); 
		return ip;
	}
}
