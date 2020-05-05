package com.oc.moko.lade.service;

import java.sql.Timestamp;
import java.util.List;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.form.FormInscription;
import com.oc.moko.lade.entity.Privilege;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	private static final String ALGORYTHME_CHIFFREMENT 		= "SHA-256";
	
	@Autowired
    private UtilisateurRepository utilisateurRepository;
	
	@Override
    @Transactional
	public void enregistrerUtilisateur(FormInscription formInscription) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenomUtilisateur(formInscription.getPrenomFormInscription());
		utilisateur.setNomUtilisateur(formInscription.getNomFormInscription());
		utilisateur.setEmailUtilisateur(formInscription.getEmailFormInscription());
		String motDePasseFormInscription = formInscription.getEmailFormInscription();
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm(ALGORYTHME_CHIFFREMENT);
        passwordEncryptor.setPlainDigest(false);
        String motDePasseChiffre = passwordEncryptor.encryptPassword(motDePasseFormInscription);
		utilisateur.setMotDePasseUtilisateur(motDePasseChiffre);
		utilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
		utilisateur.setDateInscriptionUtilisateur(new Timestamp(System.currentTimeMillis()));
		utilisateurRepository.save(utilisateur);
	}

	@Override
    @Transactional
	public Utilisateur selectionnerUtilisateurParId(Long idUtilisateur) throws ResourceNotFoundException {
        return utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new ResourceNotFoundException(idUtilisateur));
	}

	@Override
    @Transactional
    public Utilisateur selectionUtilisateurParEmail(String emailUtilisateur) {
		return utilisateurRepository.getByEmailUtilisateur(emailUtilisateur);
	}

	@Override
    @Transactional
	public boolean existanceEmail(String emailUtilisateur) {
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
