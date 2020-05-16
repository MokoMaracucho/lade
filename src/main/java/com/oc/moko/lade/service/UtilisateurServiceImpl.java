package com.oc.moko.lade.service;

import java.sql.Timestamp;
import java.util.List;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.form.FormInscription;
import com.oc.moko.lade.form.FormMajUtilisateur;
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
		List<Utilisateur> listeUtilisateurs = utilisateurRepository.findAll();
		if(listeUtilisateurs.isEmpty()) {
			utilisateur.setPrivilegeUtilisateur(Privilege.MEMBRE);
		} else {
			utilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
		}
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
	public boolean existanceEmailUtilisateur(String emailUtilisateur) {
		return utilisateurRepository.existsByEmailUtilisateur(emailUtilisateur);
	}

	@Override
    @Transactional
	public List<Utilisateur> listeUtilisateurs() {
        return utilisateurRepository.findAll();
	}

	@Override
	public FormMajUtilisateur formulaireMajUtilisateur(Utilisateur utilisateur) {
		FormMajUtilisateur formMajUtilisateur = new FormMajUtilisateur();
		formMajUtilisateur.setPrenomFormMajUtilisateur(utilisateur.getPrenomUtilisateur());
		formMajUtilisateur.setNomFormMajUtilisateur(utilisateur.getNomUtilisateur());
//		forMajUtilisateur.setEmailFormMajUtilisateur(utilisateur.getEmailUtilisateur());
    	if(utilisateur.getPrivilegeUtilisateur() == Privilege.UTILISATEUR) {
    		formMajUtilisateur.setMembreFormMajUtilisateur(false);
    	} else {
    		formMajUtilisateur.setMembreFormMajUtilisateur(true);
    	}
		return formMajUtilisateur;
	}

	@Override
	@Transactional
	public void traitementMajUtilisateur(FormMajUtilisateur formMajUtilisateur) {
		Long idUtilisateur = formMajUtilisateur.getIdFormMajUtilisateur();
		Utilisateur utilisateur = utilisateurRepository.getOne(idUtilisateur);
		if(utilisateur.getPrenomUtilisateur() != formMajUtilisateur.getPrenomFormMajUtilisateur()) {
			utilisateur.setPrenomUtilisateur(formMajUtilisateur.getPrenomFormMajUtilisateur());
		}
		if(utilisateur.getNomUtilisateur() != formMajUtilisateur.getNomFormMajUtilisateur()) {
			utilisateur.setNomUtilisateur(formMajUtilisateur.getNomFormMajUtilisateur());
		}
//		if(utilisateur.getEmailUtilisateur() != formMajUtilisateur.getEmailFormMajUtilisateur()) {
//			utilisateur.setEmailUtilisateur(formMajUtilisateur.getEmailFormMajUtilisateur());
//			String emailMaj = formMajUtilisateur.getEmailFormMajUtilisateur();
//			utilisateurRepository.majEmailUtilisateur(idUtilisateur, emailMaj);
//		}
		if(formMajUtilisateur.getMembreFormMajUtilisateur() == null) {
			formMajUtilisateur.setMembreFormMajUtilisateur(false);
		}
		if(formMajUtilisateur.getMembreFormMajUtilisateur() == true) {
			utilisateur.setPrivilegeUtilisateur(Privilege.MEMBRE);
		} else {
			utilisateur.setPrivilegeUtilisateur(Privilege.UTILISATEUR);
		}
		utilisateurRepository.save(utilisateur);
	}

	@Override
    @Transactional
	public void suppressionUtilisateurParId(Long idUtilisateur) throws ResourceNotFoundException {
		utilisateurRepository.deleteById(idUtilisateur);
	}
}
