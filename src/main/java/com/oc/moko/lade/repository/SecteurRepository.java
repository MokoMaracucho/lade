package com.oc.moko.lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Secteur;

@Repository("secteurRepository")
public interface SecteurRepository extends JpaRepository<Secteur, Long> {
    
    Secteur getByNomSecteur(String nomSecteur);
    
	@Query(value="SELECT * FROM db_lade.tb_secteur WHERE nom_secteur = :nomRecherche", nativeQuery=true)
    List<Secteur> rechercheNomSecteur(@Param("nomRecherche") String nomRecherche);
}
