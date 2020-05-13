<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<%@ page isELIgnored="false" %>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<title>Liste des sites | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>
	
	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES SITES</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>REGION</th>
					<th>COMMENTAIRES</th>
					<th>CRÉATEUR SITE</th>
					<th>MISE-À-JOUR</th>
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="site" items="${listeSites}">
					<tr class="small">
						<td>${site.idSite}</td>
						<td>${site.nomSite}</td>
						<td>${site.regionSite}</td>
						<td>
							<c:forEach var="commentaire" items="${listeCommentaires}">
							    <c:if test="${commentaire.site.idSite == site.idSite}">
							        <c:set var="found" value="true" scope="request" />
							    </c:if>
							</c:forEach>
							<c:if test="${found}">
								<form action="../commentaire/liste_commentaires_par_id_site" method="get">
									<input type="hidden" name="idSite" value="${site.idSite}" />
									<input type="submit" class="btn btn-success" value="Afficher les commentaires" />  
								</form>
							</c:if>
						</td>
						<td>${site.utilisateur.prenomUtilisateur} ${site.utilisateur.nomUtilisateur}</td>
						<td>
							<button href="${lienMaj}" class="btn btn-success">Mettre-à-jour</button>
						</td>
						<td>
							<button href="${lienSuppression}" onclick="if (!(confirm('Êtes-vous sûr de vouloir supprimer ce site ?'))) return false" class="btn btn-danger">Supprimer</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
