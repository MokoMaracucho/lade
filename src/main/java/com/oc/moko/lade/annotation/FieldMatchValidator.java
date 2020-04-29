package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.oc.moko.lade.annotation.FieldMatch;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String motDePasseFormInscription;
    private String confirmationMotDePasseFormInscription;
    private String message;

    @Override
    public void initialize(final FieldMatch annotation) {
    	this.motDePasseFormInscription = annotation.motDePasseFormInscription();
    	this.confirmationMotDePasseFormInscription = annotation.confirmationMotDePasseFormInscription();
    	this.message = annotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        
        try
        {
            final Object motDePasseFormInscriptionObj 				= BeanUtils.getProperty(value, motDePasseFormInscription);
            final Object confirmationMotDePasseFormInscriptionObj 	= BeanUtils.getProperty(value, confirmationMotDePasseFormInscription);

            valid = motDePasseFormInscriptionObj == null && confirmationMotDePasseFormInscriptionObj == null || motDePasseFormInscriptionObj != null && motDePasseFormInscriptionObj.equals(confirmationMotDePasseFormInscriptionObj);
        
        } catch (final Exception ignore) {

        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
            	.addPropertyNode(motDePasseFormInscription)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
