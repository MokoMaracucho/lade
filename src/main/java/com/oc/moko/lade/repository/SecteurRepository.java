package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Secteur;

@Repository("secteurRepository")
public interface SecteurRepository extends JpaRepository<Secteur, Long> {

}
