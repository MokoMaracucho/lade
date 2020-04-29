package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class ValidConnectionValidator implements ConstraintValidator<ValidConnection, Object> {

    private String emailFormConnection;
    private String motDePasseFormConnection;
    private String message;

    @Override
    public void initialize(final ValidConnection annotation) {
    	this.emailFormConnection = annotation.emailFormConnection();
    	this.motDePasseFormConnection = annotation.motDePasseFormConnection();
    	this.message = annotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        
        try
        {
            final String emailFormConnectionObj 		= (String) BeanUtils.getProperty(value, emailFormConnection);
            final String motDePasseFormConnectionObj 	= (String) BeanUtils.getProperty(value, motDePasseFormConnection);

//            valid = motDePasseFormInscriptionObj == null && confirmationMotDePasseFormInscriptionObj == null || motDePasseFormInscriptionObj != null && motDePasseFormInscriptionObj.equals(confirmationMotDePasseFormInscriptionObj);
        
        } catch (final Exception ignore) {

        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
            	.addPropertyNode("echec_connection")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
