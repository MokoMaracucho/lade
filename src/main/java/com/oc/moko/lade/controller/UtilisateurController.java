package com.oc.moko.lade.controller;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oc.moko.lade.form.FormConnection;
import com.oc.moko.lade.form.FormInscription;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.service.UtilisateurService;

@Controller
@SessionAttributes("sessionUtilisateur")
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	public static final String ATT_FORM_INSCRIPTION 						= "formInscription";
	public static final String ATT_FORM_CONNECTION 							= "formConnection";
	public static final String ATT_NOUVEL_UTILISATEUR 						= "nouvelUtilisateur";
 	public static final String ATT_SESSION_UTILISATEUR						= "sessionUtilisateur";
	public static final String ATT_ECHEC_INSCRIPTION_UTILISATEUR 			= "echecInscriptionUtilisateur";
	public static final String ATT_ERREURS_INSCRIPTION_UTILISATEUR 			= "erreursInscriptionUtilisateur";
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
    
    @GetMapping("/connection_utilisateur")
    public String connectionUtilisateur(Model model) {
    	model.addAttribute(ATT_FORM_CONNECTION, new FormConnection());
        return "connection_utilisateur";
    }

    @PostMapping("/traitement_formulaire_inscription")
    public String traitementInscriptionUtilisateur(HttpServletRequest request, HttpSession session, @Valid @ModelAttribute("formInscription") FormInscription formInscription, BindingResult bindingResult, Model model) {
    	session = request.getSession();
    	if(bindingResult.hasErrors()) {
        	model.addAttribute(ATT_SESSION_UTILISATEUR, false);
	        return "/inscription_utilisateur";
		} else {
			utilisateurService.enregistrerUtilisateur(formInscription);
			Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(formInscription.getEmailFormInscription());
        	session.setAttribute("sessionUtilisateur", utilisateur);
        	model.addAttribute(ATT_SESSION_UTILISATEUR, true);
        	model.addAttribute(ATT_UTILISATEUR, utilisateur);
	        return "redirect:/utilisateur/liste_utilisateurs";
		}
    }

    @PostMapping("/traitement_formulaire_connection")
    public String traitementConnectionUtilisateur(HttpServletRequest request, HttpSession session, @Valid @ModelAttribute("formConnection") FormConnection formConnection, BindingResult bindingResult, Model model) {
    	session = request.getSession();
    	if(bindingResult.hasErrors()) {
	        return "connection_utilisateur";
		} else {
			Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(formConnection.getEmailFormConnection());
			session.setAttribute(ATT_SESSION_UTILISATEUR, utilisateur);
        	model.addAttribute(ATT_UTILISATEUR, utilisateur);
	        return "redirect:/utilisateur/liste_utilisateurs";
		}	
    }

    @GetMapping("/liste_utilisateurs")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> listeUtilisateurs = utilisateurService.listeUtilisateurs();
        model.addAttribute(ATT_LISTE_UTILISATEURS, listeUtilisateurs);
        return "liste_utilisateurs";
    }

//    @GetMapping("/maj_utilisateur")
//    public String majUtilisateur(@RequestParam("idUtilisateur") UUID idUtilisateur, Model model) throws ResourceNotFoundException {
//    	Utilisateur utilisateurMaj = utilisateurService.selectionnerUtilisateurParId(idUtilisateur);
//        model.addAttribute("utilisateur", utilisateurMaj);
//        return "customer-form";
//    }

//    @GetMapping("/supprimer_utilisateur")
//    public String supprimerUtilisateurParId(@RequestParam("idUtilisateur") UUID idUtilisateur) throws ResourceNotFoundException {
//    	utilisateurService.supprimerUtilisateurParId(idUtilisateur);
//        return "redirect:/utilisateur/liste_utilisateurs";
//    }
    
    @GetMapping("/deconnection_utilisateur")
    public String deconnectionUtilisateur(HttpServletRequest request, Model model) {
	    HttpSession session = request.getSession();
	    session.invalidate();
    	model.addAttribute(ATT_SESSION_UTILISATEUR, false);
        return "redirect:/utilisateur/liste_utilisateurs";
    }
}
