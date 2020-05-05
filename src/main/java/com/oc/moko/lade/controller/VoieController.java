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

import com.oc.moko.lade.entity.Secteur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.form.FormAjoutVoie;
import com.oc.moko.lade.service.SecteurService;
import com.oc.moko.lade.service.VoieService;

@Controller
@RequestMapping("/voie")
public class VoieController {
	
	public static final String ATT_FORM_AJOUT_VOIE							= "formAjoutVoie";

	public static final String ATT_LISTE_SECTEURS				 			= "listeSecteurs";
	public static final String ATT_LISTE_VOIES								= "listeVoies";
	
	public static final String ATT_UTILISATEUR								= "utilisateur";
	
    @Autowired
    private SecteurService secteurService;
	
    @Autowired
    private VoieService voieService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/ajout_voie")
    public String ajoutVoie(Model model) {
    	model.addAttribute(ATT_FORM_AJOUT_VOIE, new FormAjoutVoie());
    	List<Secteur> listeSecteurs = secteurService.listeSecteurs();
    	model.addAttribute(ATT_LISTE_SECTEURS, listeSecteurs);
        return "ajout_voie";
    }

    @PostMapping("/traitement_formulaire_ajout_voie")
    public String traitementAjoutVoie(HttpServletRequest request, @Valid @ModelAttribute("formAjoutVoie") FormAjoutVoie formAjoutVoie, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
	        return "/ajout_voie";
		} else {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
			voieService.enregistrerVoie(formAjoutVoie, utilisateur);
	        return "redirect:/voie/liste_voies";
		}
    }

    @GetMapping("/liste_voies")
    public String listeVoies(Model model) {
        List<Voie> listeVoies = voieService.listeVoies();
        model.addAttribute(ATT_LISTE_VOIES, listeVoies);
        return "liste_voies";
    }
}
