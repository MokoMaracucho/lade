<form method="post" action="AjoutTopo" class="form form-expand-lg form-dark bg-dark form-margin-padding form-border">
	<h1 class="font-weight-bold text-light">AJOUT D'UN TOPO</h1>
	
	<div>
		<p class="${ empty traitementFormulaireAjoutTopo.erreursAjoutTopo ? 'succesConnection text-success' : 'erreurConnection text-danger' } font-weight-bold">${ traitementFormulaireAjoutTopo.resultatAjoutTopo }</p>
	</div>

  	<div class="form-group">
    	<label for="nomTopo" class="form-label-color">Nom du topo</label>
		<div class="small text-warning p-form-warning">${ traitementFormulaireAjoutTopo.erreursAjoutTopo['nomTopo'] }</div>
    	<input id="nomTopo" name="nomTopo" type="text" class="form-control" aria-describedby="nomTopo" value="<c:out value="${ nouveauTopo.nomTopo }"/>">
  	</div>
  	
  	<div class="form-group">
    	<label for="regionTopo" class="form-label-color">R�gion</label>
		<div class="small text-warning p-form-warning">${ traitementFormulaireAjoutSite.erreursAjoutSite['regionSite'] }</div>	
    	<select class="custom-select mr-sm-2" id="regionTopo" name="regionTopo">
      		<option selected></option>
        	<option value="Auvergne-Rh�ne-Alpes">Auvergne-Rh�ne-Alpes</option>
	       	<option value="Bourgogne-Franche-Comt�">Bourgogne-Franche-Comt�</option>
	        <option value="Bretagne">Bretagne</option>
	        <option value="Centre-Val de Loire">Centre-Val de Loire</option>
	        <option value="Corse">Corse</option>
	        <option value="Grand Est">Grand Est</option>
	        <option value="Guadeloupe">Guadeloupe</option>
	        <option value="Guyane">Guyane</option>
	        <option value="Haut-de-France">Haut-de-France</option>
	        <option value="�le-de-France">�le-de-France</option>
	        <option value="Martinique">Martinique</option>
	        <option value="Mayotte">Mayotte</option>
	        <option value="Normandie">Normandie</option>
	        <option value="Nouvelle-Aquitaine">Nouvelle-Aquitaine</option>
	        <option value="Occitanie">Occitanie</option>
	        <option value="Pays de la Loire">Pays de la Loire</option>
	        <option value="Provence-Alpes-Cote d'Azur">Provence-Alpes-C�te d'Azur</option>
	        <option value="La R�union">La R�union</option>
 		</select>
   	</div>
   
   	<div class="form-group">
    	<label for="descriptionTopo" class="form-label-color">Description</label>
		<div class="small text-warning p-form-warning"></div>
       	<textarea class="form-control" id="descriptionTopo" name="descriptionTopo"></textarea>
   	</div>
   
	<button type="submit" class="btn btn-success">Ajouter le topo</button>
</form>