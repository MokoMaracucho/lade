package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Longueur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutLongueur;

public interface LongueurService {
    
    public void enregistrerLongueur(FormAjoutLongueur formAjoutLongueur, Utilisateur utilisateur);

    public List<Longueur> listeLongueurs();
}
