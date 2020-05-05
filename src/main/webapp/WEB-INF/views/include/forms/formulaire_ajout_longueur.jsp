<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_ajout_longueur" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formAjoutLongueur">
		<h1 class="font-weight-bold text-light">AJOUT D'UNE LONGUEUR</h1>

		<div class="form-group">
			<label for="nomLongueur" class="form-label-color">Nom de la longueur</label>
			<form:errors path="nomLongueur" cssClass="small text-warning form-error" />
			<form:input path="nomLongueur" cssClass="form-control" />
		</div>

		<div class="form-group">
    		<label for="nomVoie" class="form-label-color">Sélectionnez une voie</label>
			<form:errors path="nomVoie" cssClass="small text-warning form-error" />
			<form:select path="nomVoie" class="custom-select mr-sm-2">
				<form:option value="" />
				<c:forEach  var="voie" items="${listeVoies}">
					<form:option value="${voie.nomVoie}" />
				</c:forEach>
			</form:select>
		</div>
		
		<div class="form-group">
			<form:errors path="cotationLongueur" cssClass="small text-warning form-error" />
			<form:label path="cotationLongueur" class="form-label-color">Cotation voie</form:label><br />
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="3" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 3</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="4a" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 4a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="4b" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 4b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="4c" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 4c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="5a" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 5a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="5b" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 5b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="5c" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 5c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="6a" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 6a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="6b" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 6b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="6c" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 6c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="7a" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 7a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="7b" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 7b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="7c" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 7c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="8a" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 8a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="8b" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 8b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="8c" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 8c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationLongueur" value="9a" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 9a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="9a+" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 9a+</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="9b" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 9b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="9b+" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 9b+</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationLongueur" value="9c" class="small form-label-color ml-2" />
					<form:label path="cotationLongueur" class="small form-label-color"> 9c</form:label>
				</span>
			</div>
		</div>

		<button type="submit" class="btn btn-success">Ajouter la longueur</button>
	</form:form>
</div>