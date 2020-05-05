package com.oc.moko.lade.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_utilisateur")
public class Utilisateur {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "id_utilisateur", updatable=false)
	private Long idUtilisateur;

	@Column(name="prenom_utilisateur")
	private String prenomUtilisateur;
	
	@Column(name="nom_utilisateur")
	private String nomUtilisateur;
	
	@Column(name="email_utilisateur")
	private String emailUtilisateur;
	
	@Column(name="mot_de_passe_utilisateur")
	private String motDePasseUtilisateur;
	
	@Enumerated(EnumType.STRING)
	@Column(name="privilege_utilisateur", length=17)
	private Privilege privilegeUtilisateur;
	
	@Column(name="date_inscription_utilisateur")
	private Timestamp dateInscriptionUtilisateur;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_site", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_site"))
	private List<Site> site;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_commentaire", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_commentaire"))
	private List<Commentaire> commentaire;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_secteur", joinColumns=@JoinColumn(name="id_utilisateur"), inverseJoinColumns=@JoinColumn(name="id_secteur"))
	private List<Secteur> secteur;
	
	public Utilisateur() {
		
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getMotDePasseUtilisateur() {
		return motDePasseUtilisateur;
	}

	public void setMotDePasseUtilisateur(String motDePasseUtilisateur) {
		this.motDePasseUtilisateur = motDePasseUtilisateur;
	}

	public Privilege getPrivilegeUtilisateur() {
		return privilegeUtilisateur;
	}

	public void setPrivilegeUtilisateur(Privilege privilegeUtilisateur) {
		this.privilegeUtilisateur = privilegeUtilisateur;
	}

	public Timestamp getDateInscriptionUtilisateur() {
		return dateInscriptionUtilisateur;
	}

	public void setDateInscriptionUtilisateur(Timestamp dateInscriptionUtilisateur) {
		this.dateInscriptionUtilisateur = dateInscriptionUtilisateur;
	}

	public List<Site> getSite() {
		return site;
	}

	public void setSite(List<Site> site) {
		this.site = site;
	}
}
