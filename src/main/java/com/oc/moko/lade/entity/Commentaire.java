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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="tb_commentaire")
public class Commentaire {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commentaire")
	private Long idCommentaire;

	@NotEmpty()
	@Column(name="commentaire")
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name="id_site")
	private Site site;
	
	public Long getIdCommentaire() {
		return idCommentaire;
	}
	
	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
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
