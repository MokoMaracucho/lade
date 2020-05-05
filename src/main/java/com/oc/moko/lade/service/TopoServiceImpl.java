package com.oc.moko.lade.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Topo;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutTopo;
import com.oc.moko.lade.repository.TopoRepository;

@Service
public class TopoServiceImpl implements TopoService {
	
	@Autowired
    private TopoRepository topoRepository;

	@Override
    @Transactional
	public void enregistrerTopo(FormAjoutTopo formAjoutTopo, Utilisateur utilisateur) {
		Topo topo = new Topo();
		topo.setNomTopo(formAjoutTopo.getNomTopo());
		topo.setRegionTopo(formAjoutTopo.getRegionTopo());
		topo.setDescriptionTopo(formAjoutTopo.getDescriptionTopo());
		topo.setDateParutionTopo(new Timestamp(System.currentTimeMillis()));
		topo.setDisponibiliteTopo(true);
		topo.setUtilisateur(utilisateur);
		topoRepository.save(topo);
	}

	@Override
    @Transactional
	public List<Topo> listeTopos() {
		return topoRepository.findAll();
	}
}
