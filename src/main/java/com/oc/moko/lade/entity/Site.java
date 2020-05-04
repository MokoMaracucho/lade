package com.oc.moko.lade.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_site")
	private Long idSite;
	
    @NotEmpty(message="Veuillez renseigner un nom pour le site.")
	@Column(name="nom_site")
	private String nomSite;
	
	@NotEmpty(message="Veuillez sélectionner une région.")
	@Column(name="region_site")
	private String regionSite;
	
//	@NotEmpty
	@ManyToOne
	private Utilisateur utilisateur;
	
//	@OneToMany(mappedBy="Secteur")
//	private List<Secteur> listeSecteurs;
	
//	@OneToMany(mappedBy="Commentaire")
//	private List<Commentaire> listeCommentaires;

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
}
