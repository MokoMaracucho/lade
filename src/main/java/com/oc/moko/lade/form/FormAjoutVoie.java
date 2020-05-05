package com.oc.moko.lade.form;

import javax.validation.constraints.NotEmpty;

public class FormAjoutVoie {

	@NotEmpty(message="Veuillez renseigner un nom pour la voie.")
	private String nomVoie;
	
	@NotEmpty(message="Veuillez sélectionner un secteur.")
	private String nomSecteur;

	private Boolean	equipeVoie;

	@NotEmpty(message="Veuillez préciser la cotation.")
	private String cotationVoie;

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getNomSecteur() {
		return nomSecteur;
	}

	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}

	public Boolean getEquipeVoie() {
		return equipeVoie;
	}

	public void setEquipeVoie(Boolean equipeVoie) {
		this.equipeVoie = equipeVoie;
	}

	public String getCotationVoie() {
		return cotationVoie;
	}

	public void setCotationVoie(String cotationVoie) {
		this.cotationVoie = cotationVoie;
	}
}
