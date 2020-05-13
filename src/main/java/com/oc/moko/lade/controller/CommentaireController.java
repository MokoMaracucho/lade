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

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.form.FormCommentaire;
import com.oc.moko.lade.service.CommentaireService;
import com.oc.moko.lade.service.SiteService;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {

	public static final String ATT_COMMENTAIRE								= "formCommentaire";
	public static final String ATT_SITE										= "site";
	public static final String ATT_UTILISATEUR								= "utilisateur";
	
	public static final String ATT_LISTE_COMMENTAIRES				 		= "listeCommentaires";
	public static final String ATT_LISTE_COMMENTAIRES_BY_ID_SITE			= "listeCommentairesByIdSite";
	
    @Autowired
    private CommentaireService commentaireService;
	
    @Autowired
    private SiteService siteService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/traitement_commentaire")
    public String traitementCommentaire(HttpServletRequest request, @Valid @ModelAttribute("formCommentaire") FormCommentaire formCommentaire, BindingResult bindingResult, Model model) {
    	HttpSession session = request.getSession();
    	if(bindingResult.hasErrors()) {
	        return "/liste_commentaires";
		} else {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_UTILISATEUR);
			Long idSite = formCommentaire.getIdSite();
	        List<Commentaire> listeCommentairesByIdSite = commentaireService.listeCommentairesByIdSite(idSite);
	        model.addAttribute(ATT_LISTE_COMMENTAIRES_BY_ID_SITE, listeCommentairesByIdSite);
			commentaireService.enregistrerCommentaire(formCommentaire, utilisateur, idSite);
	        return "redirect:/commentaire/liste_commentaires_par_id_site";
		}
    }
    
    @GetMapping("/liste_commentaires")
    public String listeCommentaires(Model model) {
        List<Commentaire> listeCommentaires = commentaireService.listeCommentaires();
        model.addAttribute(ATT_LISTE_COMMENTAIRES, listeCommentaires);
    	model.addAttribute(ATT_COMMENTAIRE, new FormCommentaire());
        return "liste_commentaires";
    }

    @GetMapping("/liste_commentaires_par_id_site")
    public String listeCommentairesByIdSite(HttpServletRequest request, @Valid @ModelAttribute("formCommentaire") FormCommentaire formCommentaire, BindingResult bindingResult, Model model) throws ResourceNotFoundException {
    	Long idSite = formCommentaire.getIdSite();
    	Site site = siteService.selectionnerSiteParId(idSite);
        model.addAttribute(ATT_SITE, site);
        List<Commentaire> listeCommentairesByIdSite = commentaireService.listeCommentairesByIdSite(idSite);
        model.addAttribute(ATT_LISTE_COMMENTAIRES_BY_ID_SITE, listeCommentairesByIdSite);
    	model.addAttribute(ATT_COMMENTAIRE, new FormCommentaire());
        return "liste_commentaires";
    }
    
    @PostMapping("/suppression_commentaire_par_id")
    public String supprimerCommentaireById(@RequestParam(name="idCommentaire") Long idCommentaire, Model model) {
    	commentaireService.supprimerCommentaireById(idCommentaire);
    	return "liste_commentaires";
    }
}
