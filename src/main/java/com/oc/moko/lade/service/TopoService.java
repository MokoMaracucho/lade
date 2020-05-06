package com.oc.moko.lade.service;

import java.util.List;

import com.oc.moko.lade.entity.Topo;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutTopo;

public interface TopoService {
    
    public void enregistrerTopo(FormAjoutTopo formAjoutTopo, Utilisateur utilisateur);

    public void enregistrerDemandeReservationTopo(Long idTopo, Utilisateur utilisateur);

    public List<Topo> listeTopos();
}
