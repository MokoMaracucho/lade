package com.oc.moko.lade.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="tb_commentaire")
public class Commentaire {

    @Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_commentaire")
	private UUID idCommentaire;

	@NotBlank
	@Column(name="commentaire")
	private String commentaire;
	
	@NotBlank
	@ManyToOne
	private Utilisateur utilisateur;
	@NotBlank
	@ManyToOne
	private Site site;
	
	public UUID getIdCommentaire() {
		return idCommentaire;
	}
	
	public void setIdCommentaire(UUID idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
