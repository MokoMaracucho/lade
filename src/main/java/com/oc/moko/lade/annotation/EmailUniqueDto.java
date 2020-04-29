package com.oc.moko.lade.annotation;

import javax.validation.constraints.NotEmpty;

import com.oc.moko.lade.annotation.EmailUnique;

public class EmailUniqueDto {

    @NotEmpty
    @EmailUnique(value="emailFormInscription")
    private String emailFormInscription;

	public String getEmailFormInscription() {
		return emailFormInscription;
	}

	public void setEmailFormInscription(String emailFormInscription) {
		this.emailFormInscription = emailFormInscription;
	}
}
