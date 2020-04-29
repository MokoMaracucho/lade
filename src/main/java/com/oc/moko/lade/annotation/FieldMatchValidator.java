package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.oc.moko.lade.annotation.FieldMatch;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String motDePasseUtilisateur;
    private String confirmationMotDePasseUtilisateur;
    private String message;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
    	motDePasseUtilisateur = constraintAnnotation.motDePasseUtilisateur();
    	confirmationMotDePasseUtilisateur = constraintAnnotation.confirmationMotDePasseUtilisateur();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        
        try
        {
            final Object motDePasseUtilisateurObj 				= BeanUtils.getProperty(value, motDePasseUtilisateur);
            final Object confirmationMotDePasseUtilisateurObj 	= BeanUtils.getProperty(value, confirmationMotDePasseUtilisateur);

            valid = motDePasseUtilisateurObj == null && confirmationMotDePasseUtilisateurObj == null || motDePasseUtilisateurObj != null && motDePasseUtilisateurObj.equals(confirmationMotDePasseUtilisateurObj);
        
        } catch (final Exception ignore) {

        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
            	.addPropertyNode(motDePasseUtilisateur)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
