package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Secteur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutSecteur;

public interface SecteurService {
    
    public void enregistrerSecteur(FormAjoutSecteur formAjoutSecteur, Utilisateur utilisateur);

    public List<Secteur> listeSecteurs();
}
