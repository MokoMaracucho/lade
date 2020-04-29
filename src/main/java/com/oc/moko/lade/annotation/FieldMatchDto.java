package com.oc.moko.lade.annotation;

import javax.validation.constraints.NotEmpty;

import com.oc.moko.lade.annotation.FieldMatch;

@FieldMatch(motDePasseFormInscription="motDePasseFormInscription", confirmationMotDePasseFormInscription="confirmationMotDePasseFormInscription", message="Les mots-de-passe doivent être identiques.")
public class FieldMatchDto {

    @NotEmpty
    private String motDePasseFormInscription;

    @NotEmpty
    private String confirmationMotDePasseFormInscription;

	public String getMotDePasseFormInscription() {
		return motDePasseFormInscription;
	}

	public void setMotDePasseFormInscription(String motDePasseFormInscription) {
		this.motDePasseFormInscription = motDePasseFormInscription;
	}

	public String getConfirmationMotDePasseFormInscription() {
		return confirmationMotDePasseFormInscription;
	}

	public void setConfirmationMotDePasseFormInscription(String confirmationMotDePasseFormInscription) {
		this.confirmationMotDePasseFormInscription = confirmationMotDePasseFormInscription;
	}
}