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
import com.oc.moko.lade.repository.ReservationTopoRepository;
import com.oc.moko.lade.repository.TopoRepository;

@Service
public class TopoServiceImpl implements TopoService {
	
	@Autowired
    private TopoRepository topoRepository;
	
	@Autowired
    private ReservationTopoRepository reservationTopoRepository;

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
	public void enregistrerReservationTopo(Long idTopo, Utilisateur utilisateur) {
		Topo topo = topoRepository.getOne(idTopo);
		topo.setDisponibiliteTopo(false);
		topoRepository.save(topo);
		ReservationTopo reservationTopo = new ReservationTopo();
		reservationTopo.setStatutReservationTopo(StatutReservationTopo.EN_ATTENTE);
		reservationTopo.setTopo(topo);
		reservationTopo.setDemandeurReservationTopo(utilisateur);
		reservationTopoRepository.save(reservationTopo);
	}

	@Override
    @Transactional
	public List<Topo> listeTopos() {
		return topoRepository.findAll();
	}

	@Override
    @Transactional
	public List<ReservationTopo> listeReservationsTopo() {
		return reservationTopoRepository.findAll();
	}

	@Override
    @Transactional
	public List<ReservationTopo> listeReservationsTopo(Long id) {
		return reservationTopoRepository.findAllByIdProprietaireTopo(id);
	}

	@Override
    @Transactional
	public List<ReservationTopo> listeDemandesReservationTopo(Long idDemandeurReservationTopo) {
		return reservationTopoRepository.findAllByIdDemandeurReservationTopo(idDemandeurReservationTopo);
	}

	@Override
    @Transactional
	public void majReservationTopo(Long idReservationTopo, Utilisateur utilisateur, StatutReservationTopo reponseReservationTopo) {
		ReservationTopo reservationTopo = reservationTopoRepository.getOne(idReservationTopo);
		switch(reponseReservationTopo) {
			case ACCEPTEE:
				reservationTopo.setStatutReservationTopo(StatutReservationTopo.ACCEPTEE);
				reservationTopoRepository.save(reservationTopo);
				break;
			case REFUSEE:
				reservationTopo.setStatutReservationTopo(StatutReservationTopo.REFUSEE);
				reservationTopoRepository.save(reservationTopo);
				break;
			case TERMINEE:
				reservationTopo.setStatutReservationTopo(StatutReservationTopo.TERMINEE);
				reservationTopoRepository.save(reservationTopo);
				break;
			default:
				break;
		}
	}
}
