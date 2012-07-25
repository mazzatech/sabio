package com.sabio.servico.validador;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidacaoHibernate implements Validar {
    
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static Validator validator;    
    private Set<ConstraintViolation<Object>> constraintViolations;
    private boolean ok = false;  		
   
	public ValidacaoHibernate(Object obj) {
        validator = factory.getValidator();	    
		validar(obj);
	}

	public ValidacaoHibernate() {
        validator = factory.getValidator(); 		
	}

    public void valida(Object obj) {
        Set<ConstraintViolation<Object>> constraints = validator.validate(obj);
        ok = constraints.isEmpty() ? true : false;   
        this.constraintViolations = constraints;
    }   
  
    @SuppressWarnings({ "rawtypes" })
    public String[] getMensagensValidacao() {
        String[] msg = new String[this.constraintViolations.size()];
        int indice = 0;

        for (ConstraintViolation value : this.constraintViolations) {  
            msg[indice] = value.getMessage();
            indice++;
        }        
    	
        return  msg;
    }   
       
    public boolean isOk() {   
        return ok;   
    }

	@Override
	public void validar(Object obj) {
		valida(obj); 
	}

	
}
