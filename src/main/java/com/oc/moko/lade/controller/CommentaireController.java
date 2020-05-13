package com.oc.moko.lade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.service.CommentaireService;
import com.oc.moko.lade.service.SiteService;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {

	public static final String ATT_SITE										= "site";
	
	public static final String ATT_LISTE_COMMENTAIRES				 		= "listeCommentaires";
	public static final String ATT_LISTE_COMMENTAIRES_BY_ID_SITE			= "listeCommentairesByIdSite";
	
    @Autowired
    private CommentaireService commentaireService;
	
    @Autowired
    private SiteService siteService;

    @GetMapping("/liste_commentaires")
    public String listeCommentaires(Model model) {
        List<Commentaire> listeCommentaires = commentaireService.listeCommentaires();
        model.addAttribute(ATT_LISTE_COMMENTAIRES, listeCommentaires);
        return "liste_commentaires";
    }

    @GetMapping("/liste_commentaires_par_id_site")
    public String listeCommentairesByIdSite(@RequestParam(name="idSite") Long idSite, Model model) throws ResourceNotFoundException {
    	Site site = siteService.selectionnerSiteParId(idSite);
        model.addAttribute(ATT_SITE, site);
        List<Commentaire> listeCommentairesByIdSite = commentaireService.listeCommentairesByIdSite(idSite);
        model.addAttribute(ATT_LISTE_COMMENTAIRES_BY_ID_SITE, listeCommentairesByIdSite);
        return "liste_commentaires";
    }
    
    @PostMapping("/suppression_commentaire_par_id")
    public String supprimerCommentaireById(@RequestParam(name="idCommentaire") Long idCommentaire, Model model) {
    	commentaireService.supprimerCommentaireById(idCommentaire);
    	return "liste_commentaires";
    }
}
