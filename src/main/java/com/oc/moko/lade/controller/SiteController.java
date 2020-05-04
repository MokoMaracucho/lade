package com.oc.moko.lade.controller;

import java.util.List;

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

import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutSite;
import com.oc.moko.lade.service.SiteService;
import com.oc.moko.lade.service.UtilisateurService;

@Controller
@RequestMapping("/site")
public class SiteController {
	
	public static final String ATT_FORM_AJOUT_SITE							= "formAjoutSite";

	public static final String ATT_LISTE_SITES				 				= "listeSites";
	
    @Autowired
    private SiteService siteService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @GetMapping("/ajout_site")
    public String ajoutSite(Model model) {
    	model.addAttribute(ATT_FORM_AJOUT_SITE, new FormAjoutSite());
        return "ajout_site";
    }

    @PostMapping("/traitement_formulaire_ajout_site")
    public String traitementInscriptionUtilisateur(@Valid @ModelAttribute("formAjoutSite") FormAjoutSite formAjoutSite, BindingResult bindingResult, Model model) {
    	if(bindingResult.hasErrors()) {
	        return "/ajout_site";
		} else {
	        return "redirect:/site/liste_sites";
		}
    }

    @GetMapping("/liste_sites")
    public String listeSites(Model model) {
        List<Site> listeSites = null;
        model.addAttribute(ATT_LISTE_SITES, listeSites);
        return "liste_sites";
    }
}
