package com.oc.moko.lade.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Commentaire;

@Repository("commentaireRepository")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	@Query(value="SELECT * FROM db_lade.tb_commentaire WHERE id_site = :idSite", nativeQuery=true)
	List<Commentaire> findAllByIdSite(@Param("idSite") Long idSite);
}
