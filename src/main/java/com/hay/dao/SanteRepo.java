package com.hay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Sante;

public interface SanteRepo extends JpaRepository<Sante, Long> {
	
	@Query("select s from Sante s   where s.dossier.idDossier = :idDossier")
	List<Sante> getContratSanteInDossier(@Param("idDossier") long idDossier);

}
