package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.form.FormInscription;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;

public interface UtilisateurService {
    
    public void enregistrerUtilisateur(FormInscription formInscription);

    public Utilisateur selectionnerUtilisateurParId(Long idUtilisateur) throws ResourceNotFoundException;
    
    public Utilisateur selectionUtilisateurParEmail(String emailUtilisateur);
    
    public boolean existanceEmail(String emailUtilisateur);

    public List<Utilisateur> listeUtilisateurs();

    public void supprimerUtilisateurParId(Long idUtilisateur) throws ResourceNotFoundException;
}
