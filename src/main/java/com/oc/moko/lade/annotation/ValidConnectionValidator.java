package com.oc.moko.lade.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.service.UtilisateurService;

public class ValidConnectionValidator implements ConstraintValidator<ValidConnection, Object> {
	
	private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";

    private String emailFormConnection;
    private String motDePasseFormConnection;
    private String message;
	
	@Autowired
	UtilisateurService utilisateurService;

    @Override
    public void initialize(final ValidConnection annotation) {
    	this.emailFormConnection = annotation.emailFormConnection();
    	this.motDePasseFormConnection = annotation.motDePasseFormConnection();
    	this.message = annotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        Utilisateur utilisateur = new Utilisateur();
        try
        {
            if(utilisateurService.existanceEmail(emailFormConnection)) {
            	utilisateur = utilisateurService.selectionUtilisateurParEmail(emailFormConnection);
				ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		        passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
		        passwordEncryptor.setPlainDigest(false);
				String motDePasseChiffreUtilisateur = utilisateur.getMotDePasseUtilisateur();
				if (passwordEncryptor.checkPassword(motDePasseFormConnection, motDePasseChiffreUtilisateur)) {
					valid = true;
				} else {
					valid = false;
				}
            }
        } catch (final Exception ignore) { }
        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
            	.addPropertyNode("echec_connection")
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        }
        return valid;
    }
}
