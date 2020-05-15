package com.oc.moko.lade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oc.moko.lade.entity.Longueur;
import com.oc.moko.lade.entity.Secteur;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Topo;
import com.oc.moko.lade.entity.Voie;
import com.oc.moko.lade.exception.ResourceNotFoundException;
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

	public static final String ATT_LISTE_SITES				 			= "listeSites";
	public static final String ATT_LISTE_SECTEURS						= "listeSecteurs";
	public static final String ATT_LISTE_VOIES							= "listeVoies";
	public static final String ATT_LISTE_LONGUEURS						= "listeLongueurs";
	public static final String ATT_LISTE_TOPOS							= "listeTopos";
	
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
    	if(!formRechercheAvancee.getNomRecherche().isEmpty() && formRechercheAvancee.getRegionRecherche().isEmpty()) {
    		List<Site> listeSites = siteService.rechercheNomSite(formRechercheAvancee.getNomRecherche());
    		if(!listeSites.isEmpty()) {
    			model.addAttribute(ATT_LISTE_SITES, listeSites);
    		}
    		List<Secteur> listeSecteurs = secteurService.rechercheNomSecteur(formRechercheAvancee.getNomRecherche());
    		if(!listeSecteurs.isEmpty()) {
    			model.addAttribute(ATT_LISTE_SECTEURS, listeSecteurs);
    		}
    		List<Voie> listeVoies = voieService.rechercheNomVoie(formRechercheAvancee.getNomRecherche());
    		if(!listeVoies.isEmpty()) {
    			model.addAttribute(ATT_LISTE_VOIES, listeVoies);
    		}
    		List<Longueur> listeLongueurs = longueurService.rechercheNomLongueur(formRechercheAvancee.getNomRecherche());
    		if(!listeLongueurs.isEmpty()) {
    			model.addAttribute(ATT_LISTE_LONGUEURS, listeLongueurs);
    		}
    		List<Topo> listeTopos = topoService.rechercheNomTopo(formRechercheAvancee.getNomRecherche());
    		if(!listeTopos.isEmpty()) {
    			model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
    		}
    	}
    	if(!formRechercheAvancee.getRegionRecherche().isEmpty() && formRechercheAvancee.getNomRecherche().isEmpty()) {
    		List<Site> listeSites = siteService.rechercheRegionSite(formRechercheAvancee.getRegionRecherche());
    		if(!listeSites.isEmpty()) {
    			model.addAttribute(ATT_LISTE_SITES, listeSites);
    		}
    		List<Topo> listeTopos = topoService.rechercheRegionTopo(formRechercheAvancee.getRegionRecherche());
    		if(!listeTopos.isEmpty()) {
    			model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
    		}
    	}
    	if(!formRechercheAvancee.getRegionRecherche().isEmpty() && !formRechercheAvancee.getNomRecherche().isEmpty()) {
    		List<Site> listeSites = siteService.rechercheNomRegionSite(formRechercheAvancee.getNomRecherche(), formRechercheAvancee.getRegionRecherche());
    		if(!listeSites.isEmpty()) {
    			model.addAttribute(ATT_LISTE_SITES, listeSites);
    		}
    		List<Topo> listeTopos = topoService.rechercheNomRegionTopo(formRechercheAvancee.getNomRecherche(), formRechercheAvancee.getRegionRecherche());
    		if(!listeTopos.isEmpty()) {
    			model.addAttribute(ATT_LISTE_TOPOS, listeTopos);
    		}
    	}
        return "resultat_recherche";
    }
}
