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

import com.oc.moko.lade.entity.Longueur;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.form.FormAjoutLongueur;
import com.oc.moko.lade.service.LongueurService;
import com.oc.moko.lade.service.VoieService;

@Controller
@RequestMapping("/longueur")
public class LongueurController {
	
	public static final String ATT_FORM_AJOUT_LONGUEUR						= "formAjoutLongueur";

	public static final String ATT_LISTE_VOIES								= "listeVoies";
	public static final String ATT_LISTE_LONGUEURS				 			= "listeLongueurs";
	
	public static final String ATT_UTILISATEUR								= "utilisateur";
	
    @Autowired
    private VoieService voieService;
	
    @Autowired
    private LongueurService longueurService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/ajout_longueur")
    public String ajoutLongueur(Model model) {
    	model.addAttribute(ATT_FORM_AJOUT_LONGUEUR, new FormAjoutLongueur());
    	List<Voie> listeVoies = voieService.listeVoies();
    	model.addAttribute(ATT_LISTE_VOIES, listeVoies);
        return "ajout_longueur";
    }

    @PostMapping("/traitement_formulaire_ajout_longueur")
    public String traitementAjoutLongueur(HttpServletRequest request, @Valid @ModelAttribute("formAjoutLongueur") FormAjoutLongueur formAjoutLongueur, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
	        return "/ajout_longueur";
		} else {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
			longueurService.enregistrerLongueur(formAjoutLongueur, utilisateur);
	        return "redirect:/longueur/liste_longueurs";
		}
    }

    @GetMapping("/liste_longueurs")
    public String listeLongueurs(Model model) {
        List<Longueur> listeLongueurs = longueurService.listeLongueurs();
        model.addAttribute(ATT_LISTE_LONGUEURS, listeLongueurs);
        return "liste_longueurs";
    }
}
