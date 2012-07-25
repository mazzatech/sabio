<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" isErrorPage="true"%> 
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.prime.com.tr/ui"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
	<ui:composition template="/templates/padraoJSF.xhtml">
		<ui:define name="barraTitulo">Sistema Academico</ui:define>	 
		<ui:define name="conteudo">
			<p:dialog header="Informa&ccedil;&otilde;es de Erro" id="dialog1" widgetVar="dialog" fixedCenter="true" modal="true">
				ESTA PAGINA DE ERRO FOI CHAMADA PELO CONTAINER POIS UMA<br/>   
				<b><%=exception.getClass().getName()%> </b>   
				foi gerada.   
				<br/>   
				A mensagem de erro gerada foi: <br>   
				<b><%=exception.getMessage()%></b>
				<br/>										
			</p:dialog>
		</ui:define>
	</ui:composition>
</html>



									