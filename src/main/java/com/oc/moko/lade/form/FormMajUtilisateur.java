package com.oc.moko.lade.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.oc.moko.lade.annotation.EmailUnique;
import com.oc.moko.lade.annotation.FieldMatch;
import com.oc.moko.lade.entity.Privilege;

@FieldMatch(motDePasseFormInscription="motDePasseFormMajUtilisateur", confirmationMotDePasseFormInscription="confirmationMotDePasseFormMajUtilisateur", message="Les mots-de-passe doivent être identiques.")
public class FormMajUtilisateur {
	
    @Size(min=2, max=30, message="Le prénom n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z -]+$", message="Le prénom n'est pas valide.")
	private String prenomFormMajUtilisateur;
	
    @Size(min=2, max=30, message="Le nom n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z -]+$", message="Le nom n'est pas valide.")
	private String nomFormMajUtilisateur;

    @Email(message="Veuillez saisir un email valide.")
	@EmailUnique(value="emailFormInscription")
	private String emailFormMajUtilisateur;

    @Size(min=5, max=30, message="L'email n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z0-9- @^_!\\\"#$%&'()*+,./:;{}<>=|~?]+$", message="Le mot-de-passe n'est pas valide.")
	private String motDePasseFormMajUtilisateur;

	private String confirmationMotDePasseFormMajUtilisateur;
	
	@Enumerated(EnumType.STRING)
	private Privilege privilegeFormMajUtilisateur;

	public String getPrenomFormMajUtilisateur() {
		return prenomFormMajUtilisateur;
	}

	public void setPrenomFormMajUtilisateur(String prenomFormMajUtilisateur) {
		this.prenomFormMajUtilisateur = prenomFormMajUtilisateur;
	}

	public String getNomFormMajUtilisateur() {
		return nomFormMajUtilisateur;
	}

	public void setNomFormMajUtilisateur(String nomFormMajUtilisateur) {
		this.nomFormMajUtilisateur = nomFormMajUtilisateur;
	}

	public String getEmailFormMajUtilisateur() {
		return emailFormMajUtilisateur;
	}

	public void setEmailFormMajUtilisateur(String emailFormMajUtilisateur) {
		this.emailFormMajUtilisateur = emailFormMajUtilisateur;
	}

	public String getMotDePasseFormMajUtilisateur() {
		return motDePasseFormMajUtilisateur;
	}

	public void setMotDePasseFormMajUtilisateur(String motDePasseFormMajUtilisateur) {
		this.motDePasseFormMajUtilisateur = motDePasseFormMajUtilisateur;
	}

	public String getConfirmationMotDePasseFormMajUtilisateur() {
		return confirmationMotDePasseFormMajUtilisateur;
	}

	public void setConfirmationMotDePasseFormMajUtilisateur(String confirmationMotDePasseFormMajUtilisateur) {
		this.confirmationMotDePasseFormMajUtilisateur = confirmationMotDePasseFormMajUtilisateur;
	}

	public Privilege getPrivilegeFormMajUtilisateur() {
		return privilegeFormMajUtilisateur;
	}

	public void setPrivilegeFormMajUtilisateur(Privilege privilegeFormMajUtilisateur) {
		this.privilegeFormMajUtilisateur = privilegeFormMajUtilisateur;
	}
}
