package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutSite;
import com.oc.moko.lade.repository.CommentaireRepository;
import com.oc.moko.lade.repository.SiteRepository;

@Service
public class SiteServiceImpl implements SiteService {
	
	@Autowired
    private SiteRepository siteRepository;
	
	@Autowired
    private CommentaireRepository commentaireRepository;

	@Override
    @Transactional
	public void enregistrerSite(FormAjoutSite formAjoutSite, Utilisateur utilisateur) {
		Site site = new Site();
		site.setNomSite(formAjoutSite.getNomSite());
		site.setRegionSite(formAjoutSite.getRegionSite());
		site.setUtilisateur(utilisateur);
		siteRepository.save(site);
		if(formAjoutSite.getCommentaireSite() != null) {
			Commentaire commentaire = new Commentaire();
			commentaire.setCommentaire(formAjoutSite.getCommentaireSite());
			commentaire.setUtilisateur(utilisateur);
			Site siteCree = siteRepository.getOne(site.getIdSite());
			commentaire.setSite(siteCree);
			commentaireRepository.save(commentaire);
		}
	}

	@Override
    @Transactional
	public List<Site> listeSites() {
		return siteRepository.findAll();
	}
}
