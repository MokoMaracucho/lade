<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<form:form action="traitement_maj_utilisateur" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formMajUtilisateur">
		<h1 class="font-weight-bold text-light">MISE-À-JOUR</h1>

		<form:hidden path="idFormMajUtilisateur" value="${utilisateur.idUtilisateur}" />

		<div class="form-group">
	    	<label for="prenomFormMajUtilisateur" class="form-label-color">Prénom</label>
			<form:errors path="prenomFormMajUtilisateur" cssClass="small text-warning form-error" />
			<form:input path="prenomFormMajUtilisateur" cssClass="form-control" />
		</div>

		<div class="form-group">
	    	<label for="nomFormMajUtilisateur" class="form-label-color">Nom</label>
			<form:errors path="nomFormMajUtilisateur" cssClass="small text-warning form-error" />
			<form:input path="nomFormMajUtilisateur" cssClass="form-control" />
		</div>

<!-- 		<div class="form-group"> -->
<!-- 			<label for="emailFormMajUtilisateur" class="text-light">Émail</label> -->
<%-- 			<form:errors path="emailFormMajUtilisateur" cssClass="small text-warning form-error" /> --%>
<%-- 			<form:input path="emailFormMajUtilisateur" cssClass="form-control" /> --%>
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label for="motDePasseFormMajUtilisateur" class="text-light">Mot-de-passe</label> -->
<%-- 			<form:errors path="motDePasseFormMajUtilisateur" cssClass="small text-warning form-error" /> --%>
<%-- 			<form:password path="motDePasseFormMajUtilisateur" cssClass="form-control" /> --%>
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label for="confirmationMotDePasseFormMajUtilisateur" class="text-light">Confirmation du mot-de-passe</label> -->
<%-- 			<form:errors path="confirmationMotDePasseFormMajUtilisateur" cssClass="small text-warning form-errorg" /> --%>
<%-- 			<form:password path="confirmationMotDePasseFormMajUtilisateur" cssClass="form-control" /> --%>
<!-- 		</div> -->
		
		<c:if test="${utilisateur.privilegeUtilisateur == 'MEMBRE'}">
			<div class="form-group">
	    		<form:checkbox path="membreFormMajUtilisateur" class="form-label-color" />
				<form:label path="membreFormMajUtilisateur" class="form-label-color"> Membre</form:label><br />
				<form:errors path="membreFormMajUtilisateur" cssClass="small text-warning form-error" />
			</div>
		</c:if>
		
		<button type="submit" class="btn btn-success">Mettre-à-jour</button>
	</form:form>
</div>