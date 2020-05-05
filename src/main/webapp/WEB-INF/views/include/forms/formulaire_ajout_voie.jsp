<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<form:form action="traitement_formulaire_ajout_voie" cssClass="form form-expand-lg form-dark bg-dark form-margin-padding form-border" method="post" modelAttribute="formAjoutVoie">
		<h1 class="font-weight-bold text-light">AJOUT D'UNE VOIE</h1>

		<div class="form-group">
			<label for="nomVoie" class="form-label-color">Nom de la voie</label>
			<form:errors path="nomVoie" cssClass="small text-warning form-error" />
			<form:input path="nomVoie" cssClass="form-control" />
		</div>

		<div class="form-group">
    		<label for="nomSecteur" class="form-label-color">Sélectionnez un secteur</label>
			<form:errors path="nomSecteur" cssClass="small text-warning form-error" />
			<form:select path="nomSecteur" class="custom-select mr-sm-2">
				<form:option value="" />
				<c:forEach  var="secteur" items="${listeSecteurs}">
					<form:option value="${secteur.nomSecteur}" />
				</c:forEach>
			</form:select>
		</div>
		
		<div class="form-group">
    		<form:checkbox path="equipeVoie" value="equipeVoie" class="form-label-color" />
			<form:label path="equipeVoie" class="form-label-color"> Voie équipée</form:label><br />
			<form:errors path="equipeVoie" cssClass="small text-warning form-error" />
		</div>
		
		<div class="form-group">
			<form:errors path="cotationVoie" cssClass="small text-warning form-error" />
			<form:label path="cotationVoie" class="form-label-color">Cotation voie</form:label><br />
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="3" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 3</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="4a" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 4a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="4b" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 4b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="4c" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 4c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="5a" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 5a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="5b" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 5b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="5c" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 5c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="6a" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 6a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="6b" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 6b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="6c" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 6c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="7a" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 7a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="7b" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 7b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="7c" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 7c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="8a" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 8a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="8b" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 8b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="8c" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 8c</form:label>
				</span>
			</div>
			
			<div class="divRadio">
				<span>
					<form:radiobutton path="cotationVoie" value="9a" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 9a</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="9a+" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 9a+</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="9b" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 9b</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="9b+" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 9b+</form:label>
				</span>
				<span>
					<form:radiobutton path="cotationVoie" value="9c" class="small form-label-color ml-2" />
					<form:label path="cotationVoie" class="small form-label-color"> 9c</form:label>
				</span>
			</div>
		</div>

		<button type="submit" class="btn btn-success">Ajouter la voie</button>
	</form:form>
</div>