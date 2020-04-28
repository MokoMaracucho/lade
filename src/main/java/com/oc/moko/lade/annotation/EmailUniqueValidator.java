package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.oc.moko.lade.service.UtilisateurService;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

	private String firstFieldName;
	private String message;
	
    @Autowired
    private UtilisateurService utilisateurService;

	@Override
	public void initialize(EmailUnique emailUnique) {
        firstFieldName = emailUnique.first();
        message = emailUnique.message();
	}

	@Override
	public boolean isValid(String emailTest, ConstraintValidatorContext context) {
		
		boolean valid = true;
		
		try {
			
//			utilisateurService.existanceEmailUtilisateur(emailTest);
			
			valid = false;
		
		} catch(final Exception ignore) {
			
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