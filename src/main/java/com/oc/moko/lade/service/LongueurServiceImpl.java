package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.moko.lade.entity.Longueur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.form.FormAjoutLongueur;
import com.oc.moko.lade.repository.LongueurRepository;
import com.oc.moko.lade.repository.VoieRepository;

@Service
public class LongueurServiceImpl implements LongueurService {
	
	@Autowired
    private VoieRepository voieRepository;
	
	@Autowired
    private LongueurRepository longueurRepository;

	@Override
	public void enregistrerLongueur(FormAjoutLongueur formAjoutLongueur, Utilisateur utilisateur) {
		Longueur longueur = new Longueur();
		longueur.setNomLongueur(formAjoutLongueur.getNomLongueur());
		longueur.setCotationLongueur(formAjoutLongueur.getCotationLongueur());
		longueur.setUtilisateur(utilisateur);
		Voie voie = voieRepository.getByNomVoie(formAjoutLongueur.getNomVoie());
		longueur.setVoie(voie);
		longueurRepository.save(longueur);
	}

	@Override
	public List<Longueur> listeLongueurs() {
		return longueurRepository.findAll();
	}
}
