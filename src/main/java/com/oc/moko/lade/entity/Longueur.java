package com.oc.moko.lade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_longueur")
public class Longueur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_longueur")
	private Long idLongueur;

	@NotEmpty
	@Column(name="nom_longueur")
	private String nomLongueur;

	@NotEmpty
	@Column(name="cotation_longueur")
	private String cotationLongueur;

	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="id_voie")
	private Voie voie;

	public Long getIdLongueur() {
		return idLongueur;
	}

	public void setIdLongueur(Long idLongueur) {
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}
}
