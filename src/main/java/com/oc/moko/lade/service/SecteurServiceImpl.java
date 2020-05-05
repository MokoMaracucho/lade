package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Secteur;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutSecteur;
import com.oc.moko.lade.repository.SecteurRepository;
import com.oc.moko.lade.repository.SiteRepository;

@Service
public class SecteurServiceImpl implements SecteurService {
	
	@Autowired
    private SiteRepository siteRepository;
	
	@Autowired
    private SecteurRepository secteurRepository;

	@Override
    @Transactional
	public void enregistrerSecteur(FormAjoutSecteur formAjoutSecteur, Utilisateur utilisateur) {
		Secteur secteur = new Secteur();
		secteur.setNomSecteur(formAjoutSecteur.getNomSecteur());
		secteur.setUtilisateur(utilisateur);
		Site site = siteRepository.getByNomSite(formAjoutSecteur.getNomSite());
		secteur.setSite(site);
		secteurRepository.save(secteur);
	}

	@Override
    @Transactional
	public List<Secteur> listeSecteurs() {
		return secteurRepository.findAll();
	}
}
