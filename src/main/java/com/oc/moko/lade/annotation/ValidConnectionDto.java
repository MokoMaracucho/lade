package com.oc.moko.lade.annotation;

import javax.validation.constraints.NotEmpty;

@ValidConnection(emailFormConnection="emailFormConnection", motDePasseFormConnection="motDePasseFormConnection", message="La connection a échouée")
public class ValidConnectionDto {

    @NotEmpty
    private String emailFormConnection;

    @NotEmpty
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
