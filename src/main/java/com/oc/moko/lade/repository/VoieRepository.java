package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oc.moko.lade.entity.Voie;

public interface VoieRepository extends JpaRepository<Voie, Long> {
    
    Voie getByNomVoie(String nomVoie);
}
