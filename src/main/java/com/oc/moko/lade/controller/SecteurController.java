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
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutSecteur;
import com.oc.moko.lade.service.SecteurService;
import com.oc.moko.lade.service.SiteService;

@Controller
@RequestMapping("/secteur")
public class SecteurController {
	
	public static final String ATT_FORM_AJOUT_SECTEUR						= "formAjoutSecteur";

	public static final String ATT_LISTE_SITES								= "listeSites";
	public static final String ATT_LISTE_SECTEURS				 			= "listeSecteurs";
	
	public static final String ATT_UTILISATEUR								= "utilisateur";
	
    @Autowired
    private SiteService siteService;
	
    @Autowired
    private SecteurService secteurService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/ajout_secteur")
    public String ajoutSecteur(Model model) {
    	List<Site> listeSites = siteService.listeSites();
    	if(!listeSites.isEmpty()) {
    		model.addAttribute(ATT_LISTE_SITES, listeSites);
    		model.addAttribute(ATT_FORM_AJOUT_SECTEUR, new FormAjoutSecteur());
    	}
        return "ajout_secteur";
    }

    @PostMapping("/traitement_formulaire_ajout_secteur")
    public String traitementAjoutSecteur(HttpServletRequest request, @Valid @ModelAttribute("formAjoutSecteur") FormAjoutSecteur formAjoutSecteur, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
	        return "/ajout_secteur";
		} else {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
			secteurService.enregistrerSecteur(formAjoutSecteur, utilisateur);
	        return "redirect:/secteur/liste_secteurs";
		}
    }

    @GetMapping("/liste_secteurs")
    public String listeSecteurs(Model model) {
        List<Secteur> listeSecteurs = secteurService.listeSecteurs();
        model.addAttribute(ATT_LISTE_SECTEURS, listeSecteurs);
        return "liste_secteurs";
    }
}
