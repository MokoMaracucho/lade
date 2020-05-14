package com.oc.moko.lade.controller;

import javax.servlet.http.HttpServletRequest;
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

import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.form.FormAjoutSite;
import com.oc.moko.lade.form.FormRechercheAvancee;
import com.oc.moko.lade.service.LongueurService;
import com.oc.moko.lade.service.SecteurService;
import com.oc.moko.lade.service.SiteService;
import com.oc.moko.lade.service.TopoService;
import com.oc.moko.lade.service.VoieService;

@Controller
@RequestMapping("/recherche")
public class RechercheController {
	
	public static final String ATT_FORM_RECHERCHE_AVANCEE				= "formRechercheAvancee";
	
    @Autowired
    private SiteService siteService;
	
    @Autowired
    private SecteurService secteurService;
	
    @Autowired
    private VoieService voieService;
	
    @Autowired
    private LongueurService longueurService;
	
    @Autowired
    private TopoService topoService;
    
    @GetMapping("/recherche_avancee")
    public String rechercheAvancee(Model model) {
    	model.addAttribute(ATT_FORM_RECHERCHE_AVANCEE, new FormRechercheAvancee());
        return "recherche_avancee";
    }
    
    @PostMapping("/traitement_formulaire_recherche_avancee")
    public String traitementFormulaireRechercheAvancee(HttpServletRequest request, FormRechercheAvancee formRechercheAvancee, Model model) throws ResourceNotFoundException {
    	if(!formRechercheAvancee.getNomRecherche().isEmpty()) {
    		siteService.rechercheNomSite(formRechercheAvancee.getNomRecherche());
    		secteurService.rechercheNomSecteur(formRechercheAvancee.getNomRecherche());
    		voieService.rechercheNomVoie(formRechercheAvancee.getNomRecherche());
    		longueurService.rechercheNomLongueur(formRechercheAvancee.getNomRecherche());
    		topoService.rechercheNomTopo(formRechercheAvancee.getNomRecherche());
    	}
    	
    	if(!formRechercheAvancee.getRegionRecherche().isEmpty()) {
    		siteService.rechercheRegionSite(formRechercheAvancee.getRegionRecherche());
    		topoService.rechercheRegionTopo(formRechercheAvancee.getRegionRecherche());
    	}
    	
    	return "resulat_recherche";
    }
}
