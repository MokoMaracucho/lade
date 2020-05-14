package com.oc.moko.lade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oc.moko.lade.form.FormRechercheAvancee;

@Controller
@RequestMapping("/recherche")
public class RechercheController {
	
	public static final String ATT_FORM_RECHERCHE_AVANCEE				= "formRechercheAvancee";
    
    @GetMapping("/recherche_avancee")
    public String rechercheAvancee(Model model) {
    	model.addAttribute(ATT_FORM_RECHERCHE_AVANCEE, new FormRechercheAvancee());
        return "recherche_avancee";
    }
}
