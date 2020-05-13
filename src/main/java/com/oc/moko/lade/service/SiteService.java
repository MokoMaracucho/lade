package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.exception.ResourceNotFoundException;
import com.oc.moko.lade.form.FormAjoutSite;

public interface SiteService {
    
    public void enregistrerSite(FormAjoutSite formAjoutSite, Utilisateur utilisateur);

    public List<Site> listeSites();
    
    public Site selectionnerSiteParId(Long idSite) throws ResourceNotFoundException;
    
    public void suppressionSiteParId(Long idSite) throws ResourceNotFoundException;
}
