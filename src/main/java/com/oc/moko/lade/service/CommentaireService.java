package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Commentaire;

public interface CommentaireService {

	public List<Commentaire> listeCommentaires();

	public List<Commentaire> listeCommentairesByIdSite(Long idSite);
	
	public void supprimerCommentaireById(Long idCommentaire);
}
