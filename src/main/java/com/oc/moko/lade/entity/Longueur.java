package com.oc.moko.lade.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_longueur")
public class Longueur {

    @Id
	@NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_longueur")
	private UUID idLongueur;

	@NotBlank
	@Column(name="nom_longueur")
	private String nomLongueur;
	@NotBlank
	@Column(name="cotation_longueur")
	private String cotationLongueur;

	@NotBlank
	@ManyToOne
	private Utilisateur utilisateur;
	@NotBlank
	@ManyToOne
	private Voie voie;
	
	public UUID getIdLongueur() {
		return idLongueur;
	}
	
	public void setIdLongueur(UUID idLongueur) {
		this.idLongueur = idLongueur;
	}
	
	public String getNomLongueur() {
		return nomLongueur;
	}
	
	public void setNomLongueur(String nomLongueur) {
		this.nomLongueur = nomLongueur;
	}
	
	public String getCotationLongueur() {
		return cotationLongueur;
	}
	
	public void setCotationLongueur(String cotationLongueur) {
		this.cotationLongueur = cotationLongueur;
	}
}
