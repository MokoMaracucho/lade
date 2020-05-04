package com.oc.moko.lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutSite {
	
    @NotEmpty(message="Veuillez renseigner un nom pour le site.")
    @Size(min=2, max=30, message="Le nom du site n'a pas la longueur appropriée.")
	private String nomSite;
	
	@NotEmpty(message="Veuillez sélectionner une région.")
	private String regionSite;

    @Size(min=2, max=300, message="Le commentaire n'a pas la longueur appropriée.")
	private String commentaireSite;

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getRegionSite() {
		return regionSite;
	}

	public void setRegionSite(String regionSite) {
		this.regionSite = regionSite;
	}

	public String getCommentaireSite() {
		return commentaireSite;
	}

	public void setCommentaireSite(String commentaireSite) {
		this.commentaireSite = commentaireSite;
	}
}
