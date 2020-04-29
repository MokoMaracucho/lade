package com.oc.moko.lade.service;

import java.util.List;
import java.util.UUID;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;

public interface UtilisateurService {
    
    public void enregistrerUtilisateur(Utilisateur utilisateur);

    public Utilisateur selectionnerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException;
    
    public boolean existanceEmailUtilisateur(String emailUtilisateur);

    public List<Utilisateur> listeUtilisateurs();

//    public void supprimerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException;
}
