package com.oc.moko.lade.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Privilege;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
    private UtilisateurRepository utilisateurRepository;
	
	@Override
    @Transactional
	public void enregistrerUtilisateur(Utilisateur utilisateur) {
		utilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
		utilisateur.setDateInscriptionUtilisateur(new Timestamp(System.currentTimeMillis()));
		utilisateurRepository.save(utilisateur);
	}

	@Override
    @Transactional
	public Utilisateur selectionnerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException {
        return utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new ResourceNotFoundException(idUtilisateur));
	}

	@Override
    @Transactional
	public boolean existanceEmailUtilisateur(String emailUtilisateur) {
		return utilisateurRepository.existsByEmailUtilisateur(emailUtilisateur);
	}

	@Override
    @Transactional
	public List<Utilisateur> listeUtilisateurs() {
        return utilisateurRepository.findAll();
	}

//	@Override
//    @Transactional
//	public void supprimerUtilisateurParId(UUID idUtilisateur) throws ResourceNotFoundException {
//		utilisateurRepository.deleteById(idUtilisateur);
//	}
}
