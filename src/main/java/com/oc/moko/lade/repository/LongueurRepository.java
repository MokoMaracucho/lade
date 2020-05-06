package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Longueur;

@Repository("longueurRepository")
public interface LongueurRepository extends JpaRepository<Longueur, Long> {

}
