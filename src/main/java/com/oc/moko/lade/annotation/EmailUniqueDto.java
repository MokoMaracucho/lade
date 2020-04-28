package com.oc.moko.lade.annotation;

import javax.validation.constraints.NotEmpty;

@EmailUnique(first="emailUtilisateur", message="Cette adresse email est déjà utilisée.")
public class EmailUniqueDto {

	@NotEmpty
    private String emailUtilisateur;

    public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

}
