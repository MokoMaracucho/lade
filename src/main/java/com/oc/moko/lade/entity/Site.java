package com.oc.moko.lade.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_site")
public class Site {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_site")
	private Long idSite;
	
    @NotEmpty(message="Veuillez renseigner un nom de site.")
	@Column(name="nom_site")
	private String nomSite;
	
	@NotEmpty(message="Veuillez sélectionner une région.")
	@Column(name="region_site")
	private String regionSite;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_secteur", joinColumns=@JoinColumn(name="id_site"), inverseJoinColumns=@JoinColumn(name="id_secteur"))
	private List<Secteur> listeSecteurs;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_commentaire", joinColumns=@JoinColumn(name="id_site"), inverseJoinColumns=@JoinColumn(name="id_commentaire"))
	private List<Commentaire> listeCommentaires;

	public Long getIdSite() {
		return idSite;
	}
	
	public void setIdSite(Long idSite) {
		this.idSite = idSite;
	}
	
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Secteur> getListeSecteurs() {
		return listeSecteurs;
	}

	public void setListeSecteurs(List<Secteur> listeSecteurs) {
		this.listeSecteurs = listeSecteurs;
	}

	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}

	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}
}
