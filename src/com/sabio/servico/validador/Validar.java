package com.sabio.servico.validador;

/**
 * Interfade responsavel em validar 
 * os atributos da classe persistente.
 * @author amorim
 *
 */
public interface Validar {
	
	
	/**
	 * Método que recebe um objeto (bean de persitencia),
	 * para validar seus atributos
	 * @param obj
	 */
	public void validar(Object obj);
	
	/**
	 * Retorna se o obejeto esta válidado ou não.
	 * @return true ou false
	 */
	public boolean isOk();
	
	
	/**
	 * Retorna um array de string, caso exista erros na
	 * validação do objeto
	 * @return
	 */
	public String[] getMensagensValidacao();

}
