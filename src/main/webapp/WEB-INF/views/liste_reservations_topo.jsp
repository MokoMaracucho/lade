<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<%@ page isELIgnored="false" %>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<title>Liste des topos | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>
	
	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES RÉSERVATIONS DE TOPOS</h1>

			<h6 class="font-weight-bold text-light">TOPOS DONT VOUS ÊTES PROPRIETAIRE</h6>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>DEMANDEUR</th>
					<th>STATUT</th>
					<th>ACCEPTER</th>
					<th>REFUSER</th>
				</tr>

				<c:forEach var="reservationTopo" items="${listeReservationsTopo}">

					<tr class="small">
						<td>${reservationTopo.idReservationTopo}</td>
						<td>${reservationTopo.topo.nomTopo}</td>
						<td>${reservationTopo.demandeurReservationTopo.prenomUtilisateur} ${reservationTopo.demandeurReservationTopo.nomUtilisateur}</td>
						<td>${reservationTopo.statutReservationTopo}</td>
						<td>
							<c:if test="${reservationTopo.statutReservationTopo == 'EN_ATTENTE'}">
								<form action="traitement_reponse_demande_reservation_topo" method="post">
									<input type="hidden" name="idReservationTopo" value="${reservationTopo.idReservationTopo}" />
									<input type="hidden" name="reponseDemandeReservationTopo" value="ACCEPTEE" />
									<input type="submit" class="btn btn-success" value="Accepter" />  
								</form>
							</c:if>
						</td>
						<td>
							<c:if test="${reservationTopo.statutReservationTopo == 'EN_ATTENTE'}">
								<form action="traitement_reponse_demande_reservation_topo" method="post">
									<input type="hidden" name="idReservationTopo" value="${reservationTopo.idReservationTopo}" />
									<input type="hidden" name="reponseDemandeReservationTopo" value="REFUSEE" />
									<input type="submit" class="btn btn-success" value="Refuser" />  
								</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<h6 class="font-weight-bold text-light">DEMANDES DE RESERVATIONS DE TOPO</h6>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>PROPRIETAIRE</th>
					<th>STATUT</th>
					<th>TERMINER</th>
				</tr>

				<c:forEach var="demandeReservationTopo" items="${listeDemandesReservationTopo}">

					<tr class="small">
						<td>${demandeReservationTopo.idReservationTopo}</td>
						<td>${demandeReservationTopo.topo.nomTopo}</td>
						<td>${demandeReservationTopo.topo.utilisateur.prenomUtilisateur} ${reservationTopo.topo.utilisateur.nomUtilisateur}</td>
						<td>${demandeReservationTopo.statutReservationTopo}</td>
						<td>
							<c:if test="${demandeReservationTopo.statutReservationTopo == 'ACCEPTEE'}">
								<form action="traitement_reponse_demande_reservation_topo" method="post">
									<input type="hidden" name="idReservationTopo" value="${demandeReservationTopo.idReservationTopo}" />
									<input type="hidden" name="reservationTopoTerminee" value="TERMINEE" />
									<input type="submit" class="btn btn-success" value="Accepter" />  
								</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
