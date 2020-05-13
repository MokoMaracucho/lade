package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutCommentaire;

public interface CommentaireService {
	
	public void enregistrerCommentaire(FormAjoutCommentaire formCommentaire, Utilisateur utilisateur, Long idSite);

	public List<Commentaire> listeCommentaires();

	public List<Commentaire> listeCommentairesByIdSite(Long idSite);
	
	public void supprimerCommentaireById(Long idCommentaire);
}
