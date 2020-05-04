<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_ajout_site" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formAjoutSite">
		<h1 class="font-weight-bold text-light">AJOUT D'UN SITE</h1>

		<div class="form-group">
			<label for="nomSite" class="form-label-color">Nom du site</label>
			<form:errors path="nomSite" cssClass="small text-warning form-error" />
			<form:input path="nomSite" cssClass="form-control" />
		</div>

		<div class="form-group">
    		<label for="regionSite" class="form-label-color">Région</label>
			<form:errors path="regionSite" cssClass="small text-warning form-error" />
			<form:select path="regionSite" class="custom-select mr-sm-2">
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

		<div class="form-group">
			<label for="commentaireSite" class="form-label-color">Commentaire</label>
        	<form:textarea path="commentaireSite" class="form-control" />
		</div>

		<button type="submit" class="btn btn-success">Enregistrer le site</button>
	</form:form>
</div>