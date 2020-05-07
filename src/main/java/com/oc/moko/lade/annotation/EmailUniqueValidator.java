package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oc.moko.lade.service.UtilisateurService;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

	protected String emailFormInscription;
	protected String message;
	
	@Autowired
	UtilisateurService utilisateurService;
	
    @Override
    public void initialize(EmailUnique annotation) {
    	this.emailFormInscription = annotation.value();
    	this.message = annotation.message();
    }
    
    @Override
    public boolean isValid(String emailFormInscription, ConstraintValidatorContext context) {
    	boolean valid = true;
        try
        {
    		valid = !utilisateurService.existanceEmail(emailFormInscription);
        } catch (final Exception ignore) { }
        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }
        return valid;
    }
}