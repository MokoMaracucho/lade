package lade.beans;

public class BN_ReservationTopoInnerJoin {
	
	private Long idReservationTopo;
	private Long idTopo;
	private Long idProprietaireTopo;
	private Long idDemandeurReservationTopo;
	private String statutReservationTopo;
	private BN_Topo topoReservationTopo;

	private BN_Utilisateur proprietaireTopo;
	private BN_Utilisateur demandeurReservationTopo;
	
	public Long getIdReservationTopo() {
		return idReservationTopo;
	}
	
	public void setIdReservationTopo(Long idReservationTopo) {
		this.idReservationTopo = idReservationTopo;
	}
	
	public Long getIdTopo() {
		return idTopo;
	}

	public void setIdTopo(Long idTopo) {
		this.idTopo = idTopo;
	}
	
	public Long getIdProprietaireTopo() {
		return idProprietaireTopo;
	}
	
	public void setIdProprietaireTopo(Long idProprietaireTopo) {
		this.idProprietaireTopo = idProprietaireTopo;
	}
	
	public Long getIdDemandeurReservationTopo() {
		return idDemandeurReservationTopo;
	}
	
	public void setIdDemandeurReservationTopo(Long idDemandeurReservationTopo) {
		this.idDemandeurReservationTopo = idDemandeurReservationTopo;
	}

	public String getStatutReservationTopo() {
		return statutReservationTopo;
	}

	public void setStatutReservationTopo(String statutReservationTopo) {
		this.statutReservationTopo = statutReservationTopo;
	}
	public BN_Topo getTopoReservationTopo() {
		return topoReservationTopo;
	}

	public void setTopoReservationTopo(BN_Topo topoReservationTopo) {
		this.topoReservationTopo = topoReservationTopo;
	}
	
	public BN_Utilisateur getProprietaireTopo() {
		return proprietaireTopo;
	}

	public void setProprietaireTopo(BN_Utilisateur proprietaireTopo) {
		this.proprietaireTopo = proprietaireTopo;
	}

	public BN_Utilisateur getDemandeurReservationTopo() {
		return demandeurReservationTopo;
	}

	public void setDemandeurReservationTopo(BN_Utilisateur demandeurReservationTopo) {
		this.demandeurReservationTopo = demandeurReservationTopo;
	}
}