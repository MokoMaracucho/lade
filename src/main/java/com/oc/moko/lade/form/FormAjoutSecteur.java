package com.oc.moko.lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutSecteur {
	
    @NotEmpty(message="Veuillez renseigner un nom de secteur.")
    @Size(min=2, max=30, message="Le nom du secteur n'a pas la longueur appropriée.")
	private String nomSecteur;
	
    @NotEmpty(message="Veuillez sélectionner un site.")
	private String nomSite;

	public String getNomSecteur() {
		return nomSecteur;
	}

	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}
}
