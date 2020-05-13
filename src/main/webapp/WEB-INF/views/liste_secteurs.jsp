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
	
	<title>Liste des secteurs | Les amis de l'escalade</title>
</head>

<body>
	<header>
		<c:import url="include/navbar/navbar.jsp" ></c:import>
	</header>
	
	<div class="container col-md-12 div-container">
		<div class="col-md-10 offset-md-1">
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES SECTEURS</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>SITE</th>
					<th>CRÉATEUR SECTEUR</th>
					<th>MISE-À-JOUR</th>
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="secteur" items="${listeSecteurs}">
			
					<c:url var="lienMaj" value="/secteur/maj_secteur">
		       			<c:param name="idSecteur" value="${secteur.idSecteur}" />
		      		</c:url>
		
				    <c:url var="lienSuppression" value="/secteur/supprimer_secteur">
				        <c:param name="idSite" value="${secteur.idSecteur}" />
				    </c:url>

					<tr class="small">
						<td>${secteur.idSecteur}</td>
						<td>${secteur.nomSecteur}</td>
						<td>${secteur.site.nomSite}</td>
						<td>${secteur.utilisateur.prenomUtilisateur} ${secteur.utilisateur.nomUtilisateur}</td>
						<td>
							<button href="${lienMaj}" class="btn btn-success">Mettre-à-jour</button>
						</td>
						<td>
							<button href="${lienSuppression}" onclick="if (!(confirm('Êtes-vous sûr de vouloir supprimer ce secteur ?'))) return false" class="btn btn-danger">Supprimer</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
