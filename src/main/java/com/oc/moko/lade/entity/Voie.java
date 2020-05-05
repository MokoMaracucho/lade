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
@Table(name="tb_voie")
public class Voie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_voie")
	private Long idVoie;

	@NotEmpty
	@Column(name="nom_voie")
	private String nomVoie;

	@Column(name="equipe_voie")
	private Boolean	equipeVoie;

	@NotEmpty
	@Column(name="cotation_voie")
	private String cotationVoie;

	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="id_secteur")
	private Secteur secteur;
	
//	@OneToMany(mappedBy="Longueur")
//	private List<Longueur> listeLongueurs;
	
	public Long getIdVoie() {
		return idVoie;
	}
	
	public void setIdVoie(Long idVoie) {
		this.idVoie = idVoie;
	}
	
	public String getNomVoie() {
		return nomVoie;
	}
	
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
}
