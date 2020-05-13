package com.oc.moko.lade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oc.moko.lade.entity.Privilege;
import com.oc.moko.lade.entity.Utilisateur;

@Repository("utilisateurRepository")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
    Boolean existsByEmailUtilisateur(String emailUtilisateur);
    
    Utilisateur getByEmailUtilisateur(String emailUtilisateur);
    
    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE tb_utilisateur u SET u.prenom_utilisateur = :prenomUtilisateur WHERE u.id_utilisateur = :idUtilisateur", nativeQuery=true)
    int majPrenomUtilisateur(@Param("idUtilisateur") Long idUtilisateur, @Param("prenomUtilisateur") String prenomUtilisateur);
    
    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE tb_utilisateur u SET u.nom_utilisateur = :nomUtilisateur WHERE u.id_utilisateur = :idUtilisateur", nativeQuery=true)
    int majNomUtilisateur(@Param("idUtilisateur") Long idUtilisateur, @Param("nomUtilisateur") String nomUtilisateur);
    
    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE tb_utilisateur u SET u.email_utilisateur = :emailUtilisateur WHERE u.id_utilisateur = :idUtilisateur", nativeQuery=true)
    int majEmailUtilisateur(@Param("idUtilisateur") Long idUtilisateur, @Param("emailUtilisateur") String emailUtilisateur);
    
    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE tb_utilisateur u SET u.privilege_utilisateur = :majPrivilegeUtilisateur WHERE u.id_utilisateur = :idUtilisateur", nativeQuery=true)
    int majPrivilegeUtilisateur(@Param("idUtilisateur") Long idUtilisateur, @Param("majPrivilegeUtilisateur") Privilege majPrivilegeUtilisateur);
}
