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
@Table(name="tb_secteur")
public class Secteur {

    @Id
	@NotBlank
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_secteur")
	private UUID idSecteur;
	
	@NotBlank
	@Column(name="nom_secteur")
	private String nomSecteur;
	
	@ManyToOne
	private Utilisateur utilisateur;
	@ManyToOne
	private Site site;
	
	@OneToMany(mappedBy="Voie")
	private List<Voie> listeVoies;

	public UUID getIdSecteur() {
		return idSecteur;
	}
	
	public void setIdSecteur(UUID idSecteur) {
		this.idSecteur = idSecteur;
	}
	
	public String getNomSecteur() {
		return nomSecteur;
	}
	
	public void setNomSecteur(String nomSecteur) {
		this.nomSecteur = nomSecteur;
	}
}
