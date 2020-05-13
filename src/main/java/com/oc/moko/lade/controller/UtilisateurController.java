package com.oc.moko.lade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oc.moko.lade.form.FormConnection;
import com.oc.moko.lade.form.FormInscription;
import com.oc.moko.lade.form.FormMajUtilisateur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.service.UtilisateurService;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	public static final String ATT_FORM_INSCRIPTION 						= "formInscription";
	public static final String ATT_FORM_CONNECTION 							= "formConnection";
	public static final String ATT_FORM_MAJ_UTILISATEUR						= "formMajUtilisateur";
	
	public static final String ATT_SESSION_STATUT							= "sessionStatut";
	
	public static final String ATT_UTILISATEUR				 				= "utilisateur";
	public static final String ATT_UTILISATEUR_MAJ				 			= "utilisateurMaj";

	public static final String ATT_LISTE_UTILISATEURS				 		= "listeUtilisateurs";
	
    @Autowired
    private UtilisateurService utilisateurService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/inscription_utilisateur")
    public String inscriptionUtilisateur(Model model) {
    	model.addAttribute(ATT_FORM_INSCRIPTION, new FormInscription());
        return "inscription_utilisateur";
    }

    @PostMapping("/traitement_formulaire_inscription")
    public String traitementInscriptionUtilisateur(HttpServletRequest request, @Valid @ModelAttribute("formInscription") FormInscription formInscription, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
        	session.setAttribute(ATT_SESSION_STATUT, false);
	        return "/inscription_utilisateur";
		} else {
			utilisateurService.enregistrerUtilisateur(formInscription);
			Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(formInscription.getEmailFormInscription());
        	session.setAttribute(ATT_SESSION_STATUT, true);
        	session.setAttribute(ATT_UTILISATEUR, utilisateur);
	        return "redirect:/utilisateur/liste_utilisateurs";
		}
    }
    
    @GetMapping("/connection_utilisateur")
    public String connectionUtilisateur(Model model) {
    	model.addAttribute(ATT_FORM_CONNECTION, new FormConnection());
        return "connection_utilisateur";
    }

    @PostMapping("/traitement_formulaire_connection")
    public String traitementConnectionUtilisateur(HttpServletRequest request, @Valid @ModelAttribute("formConnection") FormConnection formConnection, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
        	session.setAttribute(ATT_SESSION_STATUT, false);
	        return "connection_utilisateur";
		} else {
			Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(formConnection.getEmailFormConnection());
        	session.setAttribute(ATT_SESSION_STATUT, true);
			session.setAttribute(ATT_UTILISATEUR, utilisateur);
	        return "redirect:/topo/liste_reservations_topo";
		}
    }
    
    @GetMapping("/deconnection_utilisateur")
    public String deconnectionUtilisateur(HttpServletRequest request, Model model) {
	    HttpSession session = request.getSession();
	    session.invalidate();
    	model.addAttribute(ATT_SESSION_STATUT, false);
        return "redirect:/utilisateur/liste_utilisateurs";
    }

    @GetMapping("/liste_utilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.listeUtilisateurs();
        model.addAttribute(ATT_LISTE_UTILISATEURS, listeUtilisateurs);
        return "liste_utilisateurs";
    }

    @PostMapping("/maj_utilisateur")
    public String majUtilisateur(@RequestParam(name="idUtilisateur") Long idUtilisateur, Model model) throws ResourceNotFoundException {
    	Utilisateur utilisateur = utilisateurService.selectionnerUtilisateurParId(idUtilisateur);
    	FormMajUtilisateur formMajUtilisateur = utilisateurService.formulaireMajUtilisateur(utilisateur);
        model.addAttribute(ATT_FORM_MAJ_UTILISATEUR, formMajUtilisateur);
        return "maj_utilisateur";
    }
    
    @PostMapping("/traitement_maj_utilisateur")
    public String traitementMajUtilisateur(@Valid @ModelAttribute("formMajUtilisateur") FormMajUtilisateur formMajUtilisateur, BindingResult bindingResult, Model model) throws ResourceNotFoundException {
    	utilisateurService.traitementMajUtilisateur(formMajUtilisateur);
    	return "redirect:/utilisateur/liste_utilisateurs";
    }

    @PostMapping("/supprimer_utilisateur")
    public String suppressionUtilisateurParId(@RequestParam(name="idUtilisateur") Long idUtilisateur) throws ResourceNotFoundException {
    	utilisateurService.suppressionUtilisateurParId(idUtilisateur);
        return "redirect:/utilisateur/liste_utilisateurs";
    }
}
