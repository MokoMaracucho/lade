<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_connection" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formConnection">
		<h1 class="font-weight-bold text-light">CONNECTION</h1>

		<div class="form-group">
			<label for="emailFormConnection" class="text-light">Email</label>
			<form:errors path="emailFormConnection" cssClass="small text-warning form-error" />
			<form:input path="emailFormConnection" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="motDePasseFormConnection" class="text-light">Mot-de-passe</label>
			<form:errors path="motDePasseFormConnection" cssClass="small text-warning form-error" />
			<form:password path="motDePasseFormConnection" cssClass="form-control" />
		</div>

		<button type="submit" class="btn btn-success">Se connecter</button>
	</form:form>
</div>