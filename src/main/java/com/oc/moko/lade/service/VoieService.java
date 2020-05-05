package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.form.FormAjoutVoie;

public interface VoieService {
    
    public void enregistrerVoie(FormAjoutVoie formAjoutvoie, Utilisateur utilisateur);

    public List<Voie> listeVoies();
}
