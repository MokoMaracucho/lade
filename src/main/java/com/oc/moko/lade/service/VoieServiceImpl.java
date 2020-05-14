package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Secteur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.form.FormAjoutVoie;
import com.oc.moko.lade.repository.SecteurRepository;
import com.oc.moko.lade.repository.VoieRepository;

@Service
public class VoieServiceImpl implements VoieService {
	
	@Autowired
    private SecteurRepository secteurRepository;
	
	@Autowired
    private VoieRepository voieRepository;

	@Override
    @Transactional
	public void enregistrerVoie(FormAjoutVoie formAjoutVoie, Utilisateur utilisateur) {
		Voie voie = new Voie();
		voie.setNomVoie(formAjoutVoie.getNomVoie());
		voie.setEquipeVoie(formAjoutVoie.getEquipeVoie());
		voie.setCotationVoie(formAjoutVoie.getCotationVoie());
		voie.setUtilisateur(utilisateur);
		Secteur secteur = secteurRepository.getByNomSecteur(formAjoutVoie.getNomSecteur());
		voie.setSecteur(secteur);
		voieRepository.save(voie);
	}

	@Override
    @Transactional
	public List<Voie> listeVoies() {
		return voieRepository.findAll();
	}

	@Override
    @Transactional
	public void suppressionVoieParId(Long idVoie) throws ResourceNotFoundException {
		voieRepository.deleteById(idVoie);
	}
}
