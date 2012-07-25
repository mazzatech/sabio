package com.sabio.util;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class AbrirArquivo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nomeArquivo;
	private String descricao;
	//private File arquivo;

	public AbrirArquivo() {
	}

	/**
	 * Abre o arquivo no browse, passando o nome do arquivo como parametro
	 * 
	 * @param nomeArquivo
	 * @throws Exception
	 */
	public void abrir(String nomeArquivo, String descricao) throws Exception {
		this.nomeArquivo = nomeArquivo;
		this.descricao = descricao;
		abrir();
	}

	public void abrir() throws Exception {
		if (nomeArquivo == null) {
			throw new Exception("Nome do arquivo não foi especificado.");
		}

		byte[] arquivo = null;
		File file = new File(nomeArquivo);
		try {
			arquivo = fileToByte(file);
		} catch (Exception e) {
			throw new Exception("Nome do arquivo não foi especificado.\n"
					+ e.getMessage());
		}

		HttpServletResponse res = getServletResponse();

		if (nomeArquivo.toLowerCase().endsWith(".doc")
				|| nomeArquivo.toLowerCase().endsWith(".docx")) {
			res.setContentType("application/msword");
		} else if (nomeArquivo.toLowerCase().endsWith(".txt")) {
			res.setContentType("text/plain");
		} else if (nomeArquivo.toLowerCase().endsWith(".pdf")) {
			res.setContentType("application/pdf");
		} else if (nomeArquivo.toLowerCase().endsWith(".xls")
				|| nomeArquivo.toLowerCase().endsWith(".xlsx")) {
			res.setContentType("application/vnd.ms-excel");
		} else if (nomeArquivo.toLowerCase().endsWith(".jpeg")
				|| nomeArquivo.toLowerCase().endsWith(".jpg")) {
			res.setContentType("image/jpeg");
		} else {
			res.setContentType("application/octet-stream");
		}

		res.addHeader("Content-Disposition", "attachment; filename="
				+ descricao);

		if (arquivo != null && arquivo.length > 0) {
			res.setContentLength(arquivo.length);
			ServletOutputStream servletOutputStream = res.getOutputStream();
			getFacesContext().responseComplete();

			servletOutputStream.write(arquivo);
			servletOutputStream.flush();
			servletOutputStream.close();
		}
	}

	public static InputStream byteToInputStream(byte[] bytes) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		return bais;
	}

	public static byte[] fileToByte(File imagem) throws Exception {
		FileInputStream fis = new FileInputStream(imagem);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int bytesRead = 0;
		while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	private static HttpServletResponse getServletResponse() {
		return (HttpServletResponse) getFacesContext().getExternalContext()
				.getResponse();
	}

	private static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void imprimir() throws Exception {
		if (nomeArquivo == null) {
			throw new Exception("Nome do arquivo não foi especificado.");
		}

		byte[] arquivo = null;
		File file = new File(nomeArquivo);
		try {
			arquivo = fileToByte(file);
		} catch (Exception e) {
			throw new Exception("Nome do arquivo não foi especificado.\n"
					+ e.getMessage());
		}

		HttpServletResponse res = getServletResponse();

		if (nomeArquivo.toLowerCase().endsWith(".doc")
				|| nomeArquivo.toLowerCase().endsWith(".docx")) {
			res.setContentType("application/msword");
		} else if (nomeArquivo.toLowerCase().endsWith(".txt")) {
			res.setContentType("text/plain");
		} else if (nomeArquivo.toLowerCase().endsWith(".pdf")) {
			res.setContentType("application/pdf");
		} else if (nomeArquivo.toLowerCase().endsWith(".xls")
				|| nomeArquivo.toLowerCase().endsWith(".xlsx")) {
			res.setContentType("application/vnd.ms-excel");
		} else if (nomeArquivo.toLowerCase().endsWith(".jpeg")
				|| nomeArquivo.toLowerCase().endsWith(".jpg")) {
			res.setContentType("image/jpeg");
		} else {
			res.setContentType("application/octet-stream");
		}

		res.addHeader("Content-Disposition", "attachment; filename="
				+ descricao);

		if (arquivo != null && arquivo.length > 0) {
			res.setContentLength(arquivo.length);
			ServletOutputStream servletOutputStream = res.getOutputStream();
			getFacesContext().responseComplete();

			servletOutputStream.write(arquivo);
			servletOutputStream.flush();
			servletOutputStream.close();
		}
		/*
		if (arquivo != null && arquivo.length > 0) {
			res.setContentLength(arquivo.length);
			getFacesContext().responseComplete();
		}

//		res.setContentType("jpeg");//Pesquise os mime-types para saber o tipo correto   
		ByteArrayInputStream in = new ByteArrayInputStream(arquivo);   
		OutputStream out = res.getOutputStream();   
		byte[] buffer = new byte[2048];//Buffer para leitura   
		int lidos;   
		while ((lidos = in.read(buffer))!= -1){   
			out.write(buffer,0,lidos);//Transfere imagem   
			out.flush();
		}  
		//return arquivo;
		*/
	}
}
