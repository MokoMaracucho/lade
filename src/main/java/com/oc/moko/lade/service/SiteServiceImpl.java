package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
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

	@Override
    @Transactional
	public Site selectionnerSiteParId(Long idSite) throws ResourceNotFoundException {
		return siteRepository.findById(idSite).orElseThrow(() -> new ResourceNotFoundException(idSite));
	}

	@Override
    @Transactional
	public void suppressionSiteParId(Long idSite) throws ResourceNotFoundException {
		siteRepository.deleteById(idSite);
	}

	@Override
    @Transactional
	public List<Site> rechercheNomSite(String nomRecherche) throws ResourceNotFoundException {
		return siteRepository.rechercheNomSite(nomRecherche);
	}

	@Override
    @Transactional
	public List<Site> rechercheRegionSite(String regionRecherche) throws ResourceNotFoundException {
		return siteRepository.rechercheRegionSite(regionRecherche);
	}

	@Override
	public List<Site> rechercheNomRegionSite(String nomRecherche, String regionRecherche) throws ResourceNotFoundException {
		return siteRepository.rechercheNomRegionSite(nomRecherche, regionRecherche);
	}
}
