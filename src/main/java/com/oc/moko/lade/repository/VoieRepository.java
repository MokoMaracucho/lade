package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Voie;

@Repository("voieRepository")
public interface VoieRepository extends JpaRepository<Voie, Long> {
    
    Voie getByNomVoie(String nomVoie);
}
