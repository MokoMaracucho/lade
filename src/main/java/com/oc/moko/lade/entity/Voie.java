package com.oc.moko.lade.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_voie")
public class Voie {

    @Id
	@NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_voie")
	private UUID idVoie;

	@NotBlank
	@Column(name="nom_voie")
	private String nomVoie;
	@NotBlank
	@Column(name="equipe_voie")
	private Boolean	equipeVoie;
	@NotBlank
	@Column(name="cotation_voie")
	private String cotationVoie;

	@NotBlank
	@ManyToOne
	private Utilisateur utilisateur;
	@NotBlank
	@ManyToOne
	private Secteur secteur;
	
	@OneToMany(mappedBy="Longueur")
	private List<Longueur> listeLongueurs;
	
	public UUID getIdVoie() {
		return idVoie;
	}
	
	public void setIdVoie(UUID idVoie) {
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
}
