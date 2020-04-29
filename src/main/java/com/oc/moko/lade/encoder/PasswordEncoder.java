package com.oc.moko.lade.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	
	public String passwordEncoder(String motDePasseUtilisateur) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String motDePasseUtilisateurCrypte = passwordEncoder.encode(motDePasseUtilisateur);
		return motDePasseUtilisateurCrypte;
	}
}