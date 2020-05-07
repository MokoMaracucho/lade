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

import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutSite;
import com.oc.moko.lade.service.SiteService;

@Controller
@RequestMapping("/site")
public class SiteController {
	
	public static final String ATT_FORM_AJOUT_SITE							= "formAjoutSite";

	public static final String ATT_LISTE_SITES				 				= "listeSites";
	
	public static final String ATT_UTILISATEUR								= "utilisateur";
	
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
    public String traitementAjoutSite(HttpServletRequest request, @Valid @ModelAttribute("formAjoutSite") FormAjoutSite formAjoutSite, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
	        return "/ajout_site";
		} else {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
			siteService.enregistrerSite(formAjoutSite, utilisateur);
	        return "redirect:/site/liste_sites";
		}
    }

    @GetMapping("/liste_sites")
    public String listeSites(Model model) {
        List<Site> listeSites = siteService.listeSites();
        model.addAttribute(ATT_LISTE_SITES, listeSites);
        return "liste_sites";
    }
}
