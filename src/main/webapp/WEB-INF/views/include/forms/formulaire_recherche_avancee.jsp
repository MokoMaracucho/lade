<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<form:form action="traitement_formulaire_recherche_avancee" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formRechercheAvancee">
		<h1 class="font-weight-bold text-light">RECHERCHE AVANCÉE</h1>
		
		<div class="form-group">
			<label for="nomRecherche" class="form-label-color">Recherche par nom</label>
			<form:errors path="nomRecherche" cssClass="small text-warning form-error" />
			<form:input path="nomRecherche" cssClass="form-control" />
		</div>

		<div class="form-group">
    		<label for="regionRecherche" class="form-label-color">Recherche par région</label>
			<form:errors path="regionRecherche" cssClass="small text-warning form-error" />
			<form:select path="regionRecherche" class="custom-select mr-sm-2">
				<form:option value="" />
				<form:option value="Auvergne-Rhône-Alpes" />
				<form:option value="Bourgogne-Franche-Comté" />
				<form:option value="Centre-Val de Loire" />
				<form:option value="Corse" />
				<form:option value="Grand Est" />
				<form:option value="Guadeloupe" />
				<form:option value="Guyane" />
				<form:option value="Haut-de-France" />
				<form:option value="Île-de-France" />
				<form:option value="Martinique" />
				<form:option value="Mayotte" />
				<form:option value="Normandie" />
				<form:option value="Nouvelle-Aquitaine" />
				<form:option value="Occitanie" />
				<form:option value="Pays de la Loire" />
				<form:option value="Provence-Alpes-Cote d'Azur" />
				<form:option value="La Réunion" />
			</form:select>
		</div>
		
		<button type="submit" class="btn btn-success">Rechercher</button>
	</form:form>
</div>