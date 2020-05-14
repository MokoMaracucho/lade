package com.oc.moko.lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Voie;

@Repository("voieRepository")
public interface VoieRepository extends JpaRepository<Voie, Long> {
    
    Voie getByNomVoie(String nomVoie);
    
	@Query(value="SELECT * FROM db_lade.tb_voie WHERE nom_voie = :nomRecherche", nativeQuery=true)
    List<Voie> rechercheNomVoie(@Param("nomRecherche") String nomRecherche);
}
