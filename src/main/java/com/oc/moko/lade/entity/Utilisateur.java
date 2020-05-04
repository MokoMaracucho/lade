package com.oc.moko.lade.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name= "id_utilisateur", updatable=false)
	private UUID idUtilisateur;

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

//	@NotEmpty
//	@OneToMany
//	private Site site;
	
//	@NotEmpty
//	@OneToMany
//	private Commentaire commentaire;
	
	public Utilisateur() {
		
	}

	public UUID getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(UUID idUtilisateur) {
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
}
