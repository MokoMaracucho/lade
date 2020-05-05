package com.oc.moko.lade.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FormAjoutTopo {
	
    @NotEmpty(message="Veuillez renseigner un nom pour le topo.")
    @Size(min=2, max=30, message="Le nom du topo n'a pas la longueur appropriée.")
	private String nomTopo;
	
	@NotEmpty(message="Veuillez sélectionner une région.")
	private String regionTopo;

    @Size(min=2, max=300, message="La description n'a pas la longueur appropriée.")
	private String descriptionTopo;

	public String getNomTopo() {
		return nomTopo;
	}

	public void setNomTopo(String nomTopo) {
		this.nomTopo = nomTopo;
	}

	public String getRegionTopo() {
		return regionTopo;
	}

	public void setRegionTopo(String regionTopo) {
		this.regionTopo = regionTopo;
	}

	public String getDescriptionTopo() {
		return descriptionTopo;
	}

	public void setDescriptionTopo(String descriptionTopo) {
		this.descriptionTopo = descriptionTopo;
	}
}
