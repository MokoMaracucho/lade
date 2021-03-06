package com.oc.moko.lade.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_topo")
public class Topo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_topo")
	private Long idTopo;

	@NotEmpty
	@Column(name="nom_topo")
	private String nomTopo;

	@NotEmpty
	@Column(name="region_topo")
	private String regionTopo;

	@NotEmpty
	@Column(name="description_topo")
	private String descriptionTopo;

	@Column(name="date_parution_topo")
	private Timestamp dateParutionTopo;

	@Column(name="disponibilite_topo")
	private Boolean disponibiliteTopo;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	@OneToMany
	@JoinTable(name="tb_reservation_topo", joinColumns=@JoinColumn(name="id_topo"), inverseJoinColumns=@JoinColumn(name="id_reservation_topo"))
	private List<ReservationTopo> listeReservationsTopo;

	public Long getIdTopo() {
		return idTopo;
	}

	public void setIdTopo(Long idTopo) {
		this.idTopo = idTopo;
	}

	public String getNomTopo() {
		return nomTopo;
	}

	public void setNomTopo(String nomTopo) {
		this.nomTopo = nomTopo;
	}

	public String getRegionTopo() {
		return regionTopo;
	}

	public void setRegionTopo(String regionTopo) {
		this.regionTopo = regionTopo;
	}

	public String getDescriptionTopo() {
		return descriptionTopo;
	}

	public void setDescriptionTopo(String descriptionTopo) {
		this.descriptionTopo = descriptionTopo;
	}

	public Timestamp getDateParutionTopo() {
		return dateParutionTopo;
	}

	public void setDateParutionTopo(Timestamp dateParutionTopo) {
		this.dateParutionTopo = dateParutionTopo;
	}

	public Boolean getDisponibiliteTopo() {
		return disponibiliteTopo;
	}

	public void setDisponibiliteTopo(Boolean disponibiliteTopo) {
		this.disponibiliteTopo = disponibiliteTopo;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<ReservationTopo> getListeReservationsTopo() {
		return listeReservationsTopo;
	}

	public void setListeReservationTopo(List<ReservationTopo> listeReservationsTopo) {
		this.listeReservationsTopo = listeReservationsTopo;
	}
}
