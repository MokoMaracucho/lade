<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_connection_utilisateur" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="utilisateur">
		<h1 class="font-weight-bold text-light">CONNECTION</h1>

		<div class="form-group">
			<label for="emailUtilisateur" class="text-light">Émail</label>
			<form:errors path="emailUtilisateur" cssClass="small text-warning form-error" />
			<form:input path="emailUtilisateur" cssClass="form-control" />
		</div>

		<div class="form-group">
			<label for="motDePasseUtilisateur" class="text-light">Mot-de-passe</label>
			<form:errors path="motDePasseUtilisateur" cssClass="small text-warning form-error" />
			<form:password path="motDePasseUtilisateur" cssClass="form-control" />
		</div>

		<button type="submit" class="btn btn-success">Se connecter</button>
	</form:form>
</div>