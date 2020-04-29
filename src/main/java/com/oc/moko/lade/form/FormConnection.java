package com.oc.moko.lade.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class FormConnection {

	@NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
	private String emailFormConnection;

	@NotEmpty(message="Veuillez renseigner un mot-de-passe.")
	private String motDePasseFormConnection;

	public String getEmailFormConnection() {
		return emailFormConnection;
	}

	public void setEmailFormConnection(String emailFormConnection) {
		this.emailFormConnection = emailFormConnection;
	}

	public String getMotDePasseFormConnection() {
		return motDePasseFormConnection;
	}

	public void setMotDePasseFormConnection(String motDePasseFormConnection) {
		this.motDePasseFormConnection = motDePasseFormConnection;
	}
}