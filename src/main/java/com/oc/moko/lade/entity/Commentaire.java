package com.oc.moko.lade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_commentaire")
public class Commentaire {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_commentaire")
	private Long idCommentaire;

	@NotEmpty()
	@Column(name="commentaire")
	private String commentaire;
	
	@NotEmpty
	@ManyToOne
	private Utilisateur utilisateur;
	
	@NotEmpty
	@ManyToOne
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
}
