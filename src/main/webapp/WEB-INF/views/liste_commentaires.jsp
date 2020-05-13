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
	
	<title>Liste des commentaires | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>
	
	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES COMMENTAIRES</h1>

			<h6 class="font-weight-bold text-light">Site : ${site.nomSite}</h6>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>COMMENTAIRE</th>
					<th>AUTEUR</th>
					<c:if test="${utilisateur.privilegeUtilisateur eq 'MEMBRE'}">
						<th>SUPPRIMER</th>
					</c:if>
				</tr>

				<c:forEach var="commentaire" items="${listeCommentairesByIdSite}">

					<tr class="small">
						<td>${commentaire.idCommentaire}</td>
						<td>${commentaire.commentaire}</td>
						<td>${commentaire.utilisateur.prenomUtilisateur} ${commentaire.utilisateur.nomUtilisateur}</td>
						<td>
							<c:if test="${utilisateur.privilegeUtilisateur eq 'MEMBRE'}">
								<form action="suppression_commentaire_par_id" method="post">
									<input type="hidden" name="idCommentaire" value="${commentaire.idCommentaire}" />
									<input type="submit" class="btn btn-danger" value="Supprimer le commentaire" />  
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
