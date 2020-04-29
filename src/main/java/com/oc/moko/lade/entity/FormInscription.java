package com.oc.moko.lade.entity;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.oc.moko.lade.annotation.EmailUnique;
import com.oc.moko.lade.annotation.FieldMatch;

@Entity
@FieldMatch(motDePasseUtilisateur="motDePasseUtilisateur", confirmationMotDePasseUtilisateur="confirmationMotDePasseUtilisateur", message="Les mots-de-passe doivent être identiques.")
public class FormInscription {

	@NotEmpty(message="Veuillez renseigner un prénom.")
    @Size(min=2, max=30, message="Le prénom n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z -]+$", message="Le prénom n'est pas valide.")
	private String prenomFormInscription;
	
	@NotEmpty(message="Veuillez renseigner un nom.")
    @Size(min=2, max=30, message="Le nom n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z -]+$", message="Le nom n'est pas valide.")
	private String nomFormInscription;

	@NotEmpty(message="Veuillez renseigner un email.")
    @Email(message="Veuillez saisir un email valide.")
	@EmailUnique(value="emailUtilisateur")
	private String emailFormInscription;

	@NotEmpty(message="Veuillez renseigner un mot-de-passe.")
    @Size(min=5, max=30, message="L'email n'a pas la longueur appropriée.")
	@Pattern(regexp="^[a-zA-Z0-9- @^_!\\\"#$%&'()*+,./:;{}<>=|~?]+$", message="Le mot-de-passe n'est pas valide.")
	private String motDePasseFormInscription;

	@NotEmpty(message="Veuillez comfirmer le mot-de-passe.")
	private String confirmationMotDePasseFormInscription;
	
	public String getPrenomFormInscription() {
		return prenomFormInscription;
	}
	
	public void setPrenomFormInscription(String prenomFormInscription) {
		this.prenomFormInscription = prenomFormInscription;
	}
	
	public String getNomFormInscription() {
		return nomFormInscription;
	}
	
	public void setNomFormInscription(String nomFormInscription) {
		this.nomFormInscription = nomFormInscription;
	}
	
	public String getEmailFormInscription() {
		return emailFormInscription;
	}
	
	public void setEmailFormInscription(String emailFormInscription) {
		this.emailFormInscription = emailFormInscription;
	}
	
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
