package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.moko.lade.service.UtilisateurService;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

	private String firstFieldName;
	private String message;
	
    @Autowired
    private UtilisateurService utilisateurService;

	@Override
	public void initialize(final EmailUnique emailUnique) {
        firstFieldName = emailUnique.first();
        message = emailUnique.message();
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {
		
		boolean valid = true;
        try
        {
            utilisateurService.existanceEmailUtilisateur(value);
            
            valid = false;
        
        } catch (final Exception ignore) {

        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
            	.addPropertyNode(firstFieldName)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }
		
		return valid;
	}
}