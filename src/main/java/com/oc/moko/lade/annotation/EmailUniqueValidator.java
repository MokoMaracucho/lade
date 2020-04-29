package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oc.moko.lade.service.UtilisateurService;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

	protected String emailUtilisateur;
	protected String message;
	
	@Autowired
	UtilisateurService utilisateurService;
	
    @Override
    public void initialize(EmailUnique emailUtilisateur) {
    	this.emailUtilisateur = emailUtilisateur.value();
    	this.message = emailUtilisateur.message();
    }
    
    @Override
    public boolean isValid(String emailUtilisateur, ConstraintValidatorContext context) {
    	boolean valid = true;
        try
        {
    		valid = !utilisateurService.existanceEmailUtilisateur(emailUtilisateur);

        } catch (final Exception ignore) {

        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }

        return valid;
    }
}