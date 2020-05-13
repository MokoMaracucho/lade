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
	
	<title>Liste des utilisateurs | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>
	
	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES UTILISATEURS</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>PRÉNOM</th>
					<th>NOM</th>
					<th>EMAIL</th>
					<th>PRIVILÈGE</th>
					<th>DATE D'INSCRIPTION</th>
					<th>MISE-À-JOUR</th>
					<th>SUPRESSION</th>
				</tr>
				
				<c:forEach var="utilisateur" items="${listeUtilisateurs}">
				
					<tr class="small">
						<td>${utilisateur.idUtilisateur}</td>
						<td>${utilisateur.prenomUtilisateur}</td>
						<td>${utilisateur.nomUtilisateur}</td>
						<td>${utilisateur.emailUtilisateur}</td>
						<td>${utilisateur.privilegeUtilisateur}</td>
						<td>${utilisateur.dateInscriptionUtilisateur}</td>
						<td>
							<form action="maj_utilisateur" method="post">
								<input type="hidden" name="idUtilisateur" value="${utilisateur.idUtilisateur}" />
								<button class="btn btn-success">Mettre-à-jour</button>
							</form>
						</td>
						<td>
							<form action="supprimer_utilisateur" method="post">
								<input type="hidden" name="idUtilisateur" value="${utilisateur.idUtilisateur}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
