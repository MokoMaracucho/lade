<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formualire_inscription" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formInscription">
		<h1 class="font-weight-bold text-light">INSCRIPTION</h1>

		<div class="form-group">
	    	<label for="prenomFormInscription" class="form-label-color">Prénom</label>
			<form:errors path="prenomFormInscription" cssClass="small text-warning form-error" />
			<form:input path="prenomFormInscription" cssClass="form-control" />
		</div>

		<div class="form-group">
	    	<label for="nomFormInscription" class="form-label-color">Nom</label>
			<form:errors path="nomFormInscription" cssClass="small text-warning form-error" />
			<form:input path="nomFormInscription" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="emailFormInscription" class="text-light">Émail</label>
			<form:errors path="emailFormInscription" cssClass="small text-warning form-error" />
			<form:input path="emailFormInscription" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="motDePasseFormInscription" class="text-light">Mot-de-passe</label>
			<form:errors path="motDePasseFormInscription" cssClass="small text-warning form-error" />
			<form:password path="motDePasseFormInscription" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="confirmationMotDePasseFormInscription" class="text-light">Confirmation mot-de-passe</label>
			<form:errors path="confirmationMotDePasseFormInscription" cssClass="small text-warning form-errorg" />
			<form:password path="confirmationMotDePasseFormInscription" cssClass="form-control" />
		</div>

		<button type="submit" class="btn btn-success">S'inscrire</button>
	</form:form>
</div>