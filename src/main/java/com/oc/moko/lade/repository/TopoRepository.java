package com.oc.moko.lade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Privilege;
import com.oc.moko.lade.entity.Topo;

@Repository("topoRepository")
public interface TopoRepository extends JpaRepository<Topo, Long> {
    
	@Query(value="SELECT * FROM db_lade.tb_topo WHERE nom_topo = :nomRecherche", nativeQuery=true)
    List<Topo> rechercheNomTopo(@Param("nomRecherche") String nomRecherche);
    
	@Query(value="SELECT * FROM db_lade.tb_topo WHERE nom_topo = :regionRecherche", nativeQuery=true)
    List<Topo> rechercheRegionTopo(@Param("regionRecherche") String regionRecherche);
    
	@Query(value="SELECT * FROM db_lade.tb_topo WHERE nom_topo = :nomRecherche AND region_topo = :regionRecherche", nativeQuery=true)
    List<Topo> rechercheNomRegionTopo(@Param("nomRecherche") String nomRecherche, @Param("regionRecherche") String regionRecherche);
    
    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE tb_topo u SET u.disponibilite_topo = :disponibiliteTopo WHERE u.id_topo = :idTopo", nativeQuery=true)
    int majDisponibilteTopo(@Param("idTopo") Long idTopo, @Param("disponibiliteTopo") Boolean disponibiliteTopo);
}
