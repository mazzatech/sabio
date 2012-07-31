package com.sabio.controle.cadastro;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.swing.ImageIcon;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;

import com.sabio.bean.Endereco;
import com.sabio.bean.Escola;
import com.sabio.controle.ControleSession;
import com.sabio.dao.DAOFactory;
import com.sabio.servico.validador.GeraMensagem;
import com.sabio.servico.validador.ValidadorFactory;
import com.sabio.servico.validador.Validar;
import com.sabio.util.Listas;
import com.sabio.util.RedimensionarImagem;

@ManagedBean
@SessionScoped
public class ControleEscola extends ControleSession implements Serializable{
	private static final long serialVersionUID = -7517459978933604163L;
	private Escola escola;
	private List<Escola> lista;
	private String pesquisaCNPJ;
	private String pesquisaDescricao;
	private String pesquisaSigla;
	private String pesquisaNomePessoa;
	private String mensagem;
	private String retorno = "cadastro";
	private List<String> UFS;
	private String logomarca;

	public ControleEscola() {
		super("controleEscola");
	}


	public Escola getEscola() {
		return escola;
	}

	public void limpar(){
		lista 				= null;
		pesquisaCNPJ		= null;
		pesquisaDescricao 	= null;
		pesquisaSigla		= null;
		pesquisaNomePessoa	= null;
		mensagem			= null;
	}

	public String alterar(){
		setLogomarca(escola.getLogomarca());
		return "cadastro";
	}

	public String incluir(){
		escola = new Escola();
		escola.setEndereco(new Endereco());
		return "cadastro";
	}
	
	public String manutencao(){
		return "manutencao";
	}	

	public void pesquisar(){
		setLista(DAOFactory.getEscolaDAO().getSelecionar(pesquisaCNPJ, pesquisaDescricao, pesquisaSigla));
	}

	public String gravar(){

		Validar validador = ValidadorFactory.getValidador();
		validador.validar(escola);
		String[] mensagens = validador.getMensagensValidacao();
		mensagem = GeraMensagem.getMensagem(mensagens);
		retorno = "manutencao"; 

		if (validador.isOk()){
			if(escola.getCodigoEscola() == 0 ){
				try {
					DAOFactory.getEscolaDAO().inserir(escola);
					setMensagem("Cadastro com Sucesso");
					retorno = "manutencao";
					limpar();
				} catch (Exception e) {
					setMensagem("erro: "+e.getMessage());
					retorno = "cadastro";
				}
			}else{
				try {
					DAOFactory.getEscolaDAO().alterar(escola);
					retorno = "manutencao";
					limpar();
				} catch (Exception e) {
					retorno = "cadastro";
					setMensagem("erro: "+e.getMessage());
				}
				setMensagem("Altera&ccedil;&atilde;o com Sucesso");
			}
			pesquisar();

			enviaMensagem(mensagem, ControleSession.INFO);
		}else{
			enviaMensagem(mensagem, ControleSession.ERROR);
			retorno = "cadastro";
		}
		return retorno;
	}

	public String excluir(){
		try {
			DAOFactory.getEscolaDAO().excluir(escola);
		} catch (Exception e) {
			setMensagem("Erro na exclusão da Escola.");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,getMensagem(), ""));
		}
		pesquisar();
		return "manutencao";
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Escola> getLista() {
		return lista;
	}

	public void setLista(List<Escola> lista) {
		this.lista = lista;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void retorna(CloseEvent event) throws IOException {
		FacesContext faces = FacesContext.getCurrentInstance();   
		ExternalContext context = faces.getExternalContext();   
		context.redirect(retorno+".jsf");
	}

	public String getPesquisaDescricao() {
		return pesquisaDescricao;
	}

	public void setPesquisaDescricao(String pesquisaDescricao) {
		this.pesquisaDescricao = pesquisaDescricao;
	}

	public String getPesquisaCNPJ() {
		return pesquisaCNPJ;
	}

	public void setPesquisaCNPJ(String pesquisaCNPJ) {
		this.pesquisaCNPJ = pesquisaCNPJ;
	}

	public String getPesquisaSigla() {
		return pesquisaSigla;
	}

	public void setPesquisaSigla(String pesquisaSigla) {
		this.pesquisaSigla = pesquisaSigla;
	}

	public String getPesquisaNomePessoa() {
		return pesquisaNomePessoa;
	}

	public void setPesquisaNomePessoa(String pesquisaNomePessoa) {
		this.pesquisaNomePessoa = pesquisaNomePessoa;
	}

	public List<String> getUFS() {
		if (UFS == null){
			UFS = (new Listas()).getEstados();
		}
		return UFS;
	}

	/**
	 * LOGOMARCA
	 */
	public void fileUpload(FileUploadEvent event){
		Date date = new Date();
		Timestamp timestamp =  new Timestamp(date.getTime());

        String nome = event.getFile().getFileName();
        String extensao = "";

        extensao = nome.substring(nome.lastIndexOf("."), nome.length()); 
        getEscola().setLogomarca(timestamp.getTime()+extensao);

        //Pega o diretório /logo dentro do diretório atual de onde a 
        //aplicação está rodando
		String caminho = getContextPath().replace("sabio", "sabioImages")+"escolas\\logomarca\\";

         // Cria o diretório caso ele não exista
        File diretorio = new File(caminho);
        if (!diretorio.exists()){
            diretorio.mkdir();
        }

        try {
            File file = new File(diretorio, getEscola().getLogomarca());
            FileOutputStream output = new FileOutputStream(file);
            InputStream is = event.getFile().getInputstream();

            byte[] buffer = new byte[2048];
            int nLidos;
            while ((nLidos = is.read(buffer)) >= 0) {
                output.write(buffer, 0, nLidos);
            }

            output.flush();
            output.close();

            int width = 1473; // Lagura da miniatura   
            int height = 409; // Altuta da miniatura   
            int quality = 100; // Qualidade da imagem [0~100]   

            Image image = new ImageIcon(file.getPath()).getImage();
            RedimensionarImagem redimensionarImagem = new RedimensionarImagem();
            redimensionarImagem.redimensionar(image, width, height, quality, caminho+"\\"+file.getName());     		

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível incluir o anexo", ""));
		}
	}

	public String getLogomarca() throws Exception {

		if(getEscola() != null){
			File im = new File(getContextPath().replace("sabio", "sabioImages")+"escolas/logomarca/"+getEscola().getLogomarca());
			if(im.exists()){
				logomarca = "http://"+getIpServer()+"/sabioImages/escolas/logomarca/"+getEscola().getLogomarca();
			}
		}else{
			logomarca = "";
		}

		return logomarca;
	}
	
	public void setLogomarca(String logomarca){
		this.logomarca = logomarca;
	}
}