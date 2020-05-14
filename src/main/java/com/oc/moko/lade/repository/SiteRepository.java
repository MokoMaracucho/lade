package com.oc.moko.lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Site;

@Repository("siteRepository")
public interface SiteRepository extends JpaRepository<Site, Long> {
    
    Site getByNomSite(String nomSite);
    
	@Query(value="SELECT * FROM db_lade.tb_site WHERE nom_site = :nomRecherche", nativeQuery=true)
    List<Site> rechercheNomSite(@Param("nomRecherche") String nomRecherche);
    
	@Query(value="SELECT * FROM db_lade.tb_site WHERE region_site = :regionRecherche", nativeQuery=true)
    List<Site> rechercheRegionSite(@Param("regionRecherche") String regionRecherche);
    
	@Query(value="SELECT * FROM db_lade.tb_site WHERE nom_site = :nomRecherche AND WHERE region_site = :regionRecherche", nativeQuery=true)
    List<Site> rechercheNomRegionSite(@Param("nomRecherche") String nomRecherche, @Param("regionRecherche") String regionRecherche);
}
