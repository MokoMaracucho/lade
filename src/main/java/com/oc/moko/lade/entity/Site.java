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
@Table(name="tb_site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	@Column(name="id_site")
	private UUID idSite;
	
	@Column(name="nom_site")
	private String nomSite;
	@NotBlank
	@Column(name="region_site")
	private String regionSite;

	@NotBlank
	@ManyToOne
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="Secteur")
	private List<Secteur> listeSecteurs;
	@OneToMany(mappedBy="Commentaire")
	private List<Commentaire> listeCommentaires;

	public UUID getIdSite() {
		return idSite;
	}
	
	public void setIdSite(UUID idSite) {
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
