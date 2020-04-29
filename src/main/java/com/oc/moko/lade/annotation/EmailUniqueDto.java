package com.oc.moko.lade.annotation;

import javax.validation.constraints.NotEmpty;

import com.oc.moko.lade.annotation.EmailUnique;

public class EmailUniqueDto {

    @NotEmpty
    @EmailUnique(value = "emailUtilisateur")
    private String emailUtilisateur;

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
}
