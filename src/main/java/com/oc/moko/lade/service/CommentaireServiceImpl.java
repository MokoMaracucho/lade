package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutCommentaire;
import com.oc.moko.lade.repository.CommentaireRepository;
import com.oc.moko.lade.repository.SiteRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
    private CommentaireRepository commentaireRepository;
	
	@Autowired
    private SiteRepository siteRepository;

	@Override
	public void enregistrerCommentaire(FormAjoutCommentaire formCommentaire, Utilisateur utilisateur, Long idSite) {
		Commentaire commentaire = new Commentaire();
		commentaire.setCommentaire(formCommentaire.getCommentaire());
		commentaire.setUtilisateur(utilisateur);
		Site site = siteRepository.getOne(idSite);
		commentaire.setSite(site);
		commentaireRepository.save(commentaire);
	}

	@Override
    @Transactional
	public List<Commentaire> listeCommentaires() {
        return commentaireRepository.findAll();
	}

	@Override
    @Transactional
	public List<Commentaire> listeCommentairesByIdSite(Long idSite) {
        return commentaireRepository.findAllByIdSite(idSite);
	}

	@Override
	public void supprimerCommentaireById(Long idCommentaire) {
		commentaireRepository.deleteById(idCommentaire);
	}
}
