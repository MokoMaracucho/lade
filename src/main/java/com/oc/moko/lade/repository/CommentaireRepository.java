package com.oc.moko.lade.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Commentaire;

@Repository("commentaireRepository")
public interface CommentaireRepository extends JpaRepository<Commentaire, UUID> {

}
