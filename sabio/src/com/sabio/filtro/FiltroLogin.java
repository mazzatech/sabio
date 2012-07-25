/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabio.filtro;

 import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fejal.seguranca.bean.Area;
import com.fejal.seguranca.bean.Grupo;
import com.fejal.seguranca.bean.Usuario;


/**
 *
 * @author dyego
 */
public class FiltroLogin implements Filter {

    private HttpSession session;

    public FiltroLogin() {
    } 

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

    HttpServletRequest rq = (HttpServletRequest)request;
    HttpServletResponse rp = (HttpServletResponse)response;

    session = rq.getSession();
    session.removeAttribute("acessoNegado");
    boolean auth = session.getAttribute("usr") != null;
    if ( ! rq.getRequestURL().toString().contains("login.jsf") && 
        	 ! rq.getRequestURL().toString().contains("principal.jsf") &&
        	 ! rq.getRequestURL().toString().contains(".css.jsf") &&
        	 ! rq.getRequestURL().toString().contains(".js.jsf") &&
        	 ! rq.getRequestURL().toString().contains(".png") &&
        	 ! rq.getRequestURL().toString().contains(".gif") &&
        	 ! rq.getRequestURL().toString().contains(".jpg") &&
        	 ! rq.getRequestURL().toString().contains(".swf") &&
        	 ! rq.getRequestURL().toString().contains("alteraDados.jsf")){

	    if (! auth ) {
	    	session.setAttribute("url", rq.getRequestURL().toString());
	    	rp.sendRedirect("/sabio/login.jsf");
	        return;
	    }else{
            Usuario usuario 	= (Usuario) session.getAttribute("usr");
            int codigoSistema 	= (Integer) session.getAttribute("codigoSistema");

            boolean isPermissao =false;
    		for (Grupo g : usuario.getGrupos()){
    			if(g.getSistema().getCodigoSistema() == codigoSistema ){
    	            if (isPermissao(g, rq.getRequestURL().toString())){
    	            	isPermissao = true;
    	            	break;
    	            }
    			}
    		}

            if ( !isPermissao){
            	session.setAttribute("url", rq.getRequestURL().toString());
            	/*
            	 * Melhor criar uma pagina para 
            	 * informar que o usuario não tem 
            	 * permissão
            	 */
            	session.setAttribute("msg", "Usu&aacute;rio sem permiss&atilde;o");
            	rp.sendRedirect("/sabio/principal.jsf");
                return;
            }
	    }
    }
    
	try {
	    chain.doFilter(request, response);
	}
	catch(Throwable t) {
	    t.printStackTrace();
	}

    }


	private boolean isPermissao(Grupo grupo, String url) {

		boolean ok = false;

		for ( Area area :  grupo.getAreas() ){
			if ( url.contains(area.getURL())){
				ok = true;
			}
		}

		return ok;
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
    
   
}
