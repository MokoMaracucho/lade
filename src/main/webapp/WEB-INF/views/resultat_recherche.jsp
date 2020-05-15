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
	
	<title>Résultat de la recherche | Les amis de l'escalade</title>
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
<!-- 					<th>MISE-À-JOUR</th> -->
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
<!-- 						<td> -->
<%-- 							<form action="maj_site" method="post"> --%>
<%-- 								<input type="hidden" name="idSite" value="${site.idSite}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<td>
							<form action="supprimer_site" method="post">
								<input type="hidden" name="idSite" value="${site.idSite}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
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
					<tr class="small">
						<td>${secteur.idSecteur}</td>
						<td>${secteur.nomSecteur}</td>
						<td>${secteur.site.nomSite}</td>
						<td>${secteur.utilisateur.prenomUtilisateur} ${secteur.utilisateur.nomUtilisateur}</td>
<!-- 						<td> -->
<%-- 							<form action="maj_secteur" method="post"> --%>
<%-- 								<input type="hidden" name="idSecteur" value="${secteur.idSecteur}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<td>
							<form action="supprimer_secteur" method="post">
								<input type="hidden" name="idSecteur" value="${secteur.idSecteur}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES VOIES</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>SECTEUR</th>
					<th>VOIE ÉQUIPÉE</th>
					<th>COTATION</th>
					<th>CRÉATEUR VOIE</th>
					<th>MISE-À-JOUR</th>
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="voie" items="${listeVoies}">
					<tr class="small">
						<td>${voie.idVoie}</td>
						<td>${voie.nomVoie}</td>
						<td>${voie.secteur.nomSecteur}</td>
						<td>${voie.equipeVoie ? "Oui" : "Non"}</td>
						<td>${voie.cotationVoie}</td>
						<td>${voie.utilisateur.prenomUtilisateur} ${voie.utilisateur.nomUtilisateur}</td>
<!-- 						<td> -->
<%-- 							<form action="maj_voie" method="post"> --%>
<%-- 								<input type="hidden" name="idVoie" value="${voie.idVoie}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<td>
							<form action="supprimer_voie" method="post">
								<input type="hidden" name="idVoie" value="${voie.idVoie}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			
			<h1 class="font-weight-bold text-light">LISTE DES LONGUEURS</h1>

			<table class="table table-striped table-bordered table-dark">
				<tr class="small">
					<th>ID</th>
					<th>NOM</th>
					<th>VOIE</th>
					<th>COTATION</th>
					<th>CRÉATEUR LONGUEUR</th>
					<th>MISE-À-JOUR</th>
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="longueur" items="${listeLongueurs}">
			
					<c:url var="lienMaj" value="/longueur/maj_longueur">
		       			<c:param name="idLongueur" value="${longueur.idLongueur}" />
		      		</c:url>
		
				    <c:url var="lienSuppression" value="/longueur/supprimer_longueur">
				        <c:param name="idLongueur" value="${longueur.idLongueur}" />
				    </c:url>

					<tr class="small">
						<td>${longueur.idLongueur}</td>
						<td>${longueur.nomLongueur}</td>
						<td>${longueur.voie.nomVoie}</td>
						<td>${longueur.cotationLongueur}</td>
						<td>${longueur.utilisateur.prenomUtilisateur} ${longueur.utilisateur.nomUtilisateur}</td>
<!-- 						<td> -->
<%-- 							<form action="maj_voie" method="post"> --%>
<%-- 								<input type="hidden" name="idLongueur" value="${longueur.idLongueur}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<td>
							<form action="supprimer_longueur" method="post">
								<input type="hidden" name="idLongueur" value="${longueur.idLongueur}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
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
<!-- 					<th>MISE-À-JOUR</th> -->
					<th>SUPRESSION</th>
				</tr>

				<c:forEach var="topo" items="${listeTopos}">
					<tr class="small">
						<td>${topo.idTopo}</td>
						<td>${topo.nomTopo}</td>
						<td>${topo.regionTopo}</td>
						<td>${topo.descriptionTopo}</td>
						<td>${topo.utilisateur.prenomUtilisateur} ${topo.utilisateur.nomUtilisateur}</td>
						<td>${topo.dateParutionTopo}</td>
<!-- 						<td> -->
<%-- 							<form action="maj_topo" method="post"> --%>
<%-- 								<input type="hidden" name="idTopo" value="${topo.idTopo}" /> --%>
<!-- 								<button class="btn btn-success">Mettre-à-jour</button> -->
<%-- 							</form> --%>
<!-- 						</td> -->
						<td>
							<form action="supprimer_topo" method="post">
								<input type="hidden" name="idTopo" value="${topo.idTopo}" />
								<button class="btn btn-danger">Supprimer</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
