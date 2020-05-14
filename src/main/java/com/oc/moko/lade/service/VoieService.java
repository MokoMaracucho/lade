package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.form.FormAjoutVoie;

public interface VoieService {
    
    public void enregistrerVoie(FormAjoutVoie formAjoutVoie, Utilisateur utilisateur);

    public List<Voie> listeVoies();
    
    public void suppressionVoieParId(Long idVoie) throws ResourceNotFoundException;
}
