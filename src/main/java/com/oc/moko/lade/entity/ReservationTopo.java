package com.oc.moko.lade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_reservation_topo")
public class ReservationTopo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation_topo")
	private Long idReservationTopo;

	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name="statut_reservation_topo")
	private StatutReservationTopo statutReservationTopo;

	@ManyToOne
	@JoinColumn(name="id_topo")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur demandeurReservationTopo;
}
