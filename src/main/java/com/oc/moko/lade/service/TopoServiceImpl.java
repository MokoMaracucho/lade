package com.oc.moko.lade.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.ReservationTopo;
import com.oc.moko.lade.entity.StatutReservationTopo;
import com.oc.moko.lade.entity.Topo;
import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.form.FormAjoutTopo;
import com.oc.moko.lade.repository.DemandeReservationTopoRepository;
import com.oc.moko.lade.repository.TopoRepository;

@Service
public class TopoServiceImpl implements TopoService {
	
	@Autowired
    private TopoRepository topoRepository;
	
	@Autowired
    private DemandeReservationTopoRepository demandeReservationTopoRepository;

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
	public void enregistrerDemandeReservationTopo(Long idTopo, Utilisateur utilisateur) {
		Topo topo = topoRepository.getOne(idTopo);
		topo.setDisponibiliteTopo(false);
		topoRepository.save(topo);
		ReservationTopo demandeReservationTopo = new ReservationTopo();
		demandeReservationTopo.setStatutReservationTopo(StatutReservationTopo.EN_ATTENTE);
		demandeReservationTopo.setDemandeurReservationTopo(utilisateur);
		demandeReservationTopoRepository.save(demandeReservationTopo);
	}

	@Override
    @Transactional
	public List<Topo> listeTopos() {
		return topoRepository.findAll();
	}
}
