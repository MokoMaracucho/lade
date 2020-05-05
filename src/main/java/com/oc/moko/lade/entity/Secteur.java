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
@Table(name="tb_secteur")
public class Secteur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_secteur")
	private Long idSecteur;
	
    @NotEmpty
	@Column(name="nom_secteur")
	private String nomSecteur;

	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name="id_site")
	private Site site;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_voie", joinColumns=@JoinColumn(name="id_secteur"), inverseJoinColumns=@JoinColumn(name="id_voie"))
	private List<Voie> voie;

	public Long getIdSecteur() {
		return idSecteur;
	}
	
	public void setIdSecteur(Long idSecteur) {
		this.idSecteur = idSecteur;
	}
	
	public String getNomSecteur() {
		return nomSecteur;
	}
	
	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
