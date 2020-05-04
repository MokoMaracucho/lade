package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Site;
import com.oc.moko.lade.form.FormAjoutSite;

public interface SiteService {
    
    public void enregistrerUtilisateur(FormAjoutSite formAjoutSite);

    public List<Site> listeSites();
}
