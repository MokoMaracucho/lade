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
			
			<h1 class="font-weight-bold text-light">LISTE DES TOPOS</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>REGION</th>
					<th>DESCRIPTION</th>
					<th>PROPRIÉTAIRE</th>
					<th>DATE PARUTION</th>
					<th>DISPONIBILITÉ</th>
					<th>MISE-À-JOUR</th>
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="topo" items="${listeTopos}">
			
					<c:url var="lienDemandeReservationTopo" value="/lade/topo/traitement_demande_reservation_topo">
		       			<c:param name="topo" value="${topo}" />
		      		</c:url>
			
					<c:url var="lienMaj" value="/topo/maj_topo">
		       			<c:param name="idTopo" value="${topo.idTopo}" />
		      		</c:url>
		
				    <c:url var="lienSuppression" value="/topo/supprimer_topo">
				        <c:param name="idTopo" value="${topo.idTopo}" />
				    </c:url>

					<tr class="small">
						<td>${topo.idTopo}</td>
						<td>${topo.nomTopo}</td>
						<td>${topo.regionTopo}</td>
						<td>${topo.descriptionTopo}</td>
						<td>${topo.utilisateur.prenomUtilisateur} ${topo.utilisateur.nomUtilisateur}</td>
						<td>${topo.dateParutionTopo}</td>
						<td>
							<c:if test="${topo.disponibiliteTopo}">
								<form action="traitement_demande_reservation_topo" method="post">
								
<%-- 									<input type="hidden" name="topo" value="${topo}"/> --%>
<!-- 									<a type="submit" class="btn btn-succes">Demande de réservation</a> -->
									
									<input type="hidden" name="idTopo" value="${topo.idTopo}" />
									<input type="submit" class="btn btn-success" value="Demande de réservation" />  
								</form>
							</c:if>
						</td>
						<td>
							<button href="${lienMaj}" class="btn btn-success">Mettre-à-jour</button>
						</td>
						<td>
							<button href="${lienSuppression}" onclick="if (!(confirm('Êtes-vous sûr de vouloir supprimer ce topo ?'))) return false" class="btn btn-danger">Supprimer</button>
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
