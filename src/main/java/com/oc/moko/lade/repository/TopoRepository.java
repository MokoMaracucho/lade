package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Topo;

@Repository("topoRepository")
public interface TopoRepository extends JpaRepository<Topo, Long> {

}
