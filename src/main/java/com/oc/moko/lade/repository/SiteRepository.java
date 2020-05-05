package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Site;

@Repository("siteRepository")
public interface SiteRepository extends JpaRepository<Site, Long> {
    
    Site getByNomSite(String nomSite);
}
