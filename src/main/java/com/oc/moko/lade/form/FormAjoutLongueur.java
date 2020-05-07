package com.oc.moko.lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutLongueur {

	@NotEmpty(message="Veuillez renseigner un nom pour la longueur.")
    @Size(min=2, max=30, message="Le nom de la longueur n'a pas la longueur appropriée.")
	private String nomLongueur;
	
	@NotEmpty(message="Veuillez sélectionner une voie.")
	private String nomVoie;

	@NotEmpty(message="Veuillez préciser la cotation.")
	private String cotationLongueur;

	public String getNomLongueur() {
		return nomLongueur;
	}

	public void setNomLongueur(String nomLongueur) {
		this.nomLongueur = nomLongueur;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getCotationLongueur() {
		return cotationLongueur;
	}

	public void setCotationLongueur(String cotationLongueur) {
		this.cotationLongueur = cotationLongueur;
	}
}
