package com.hay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Auto;

public interface AutoRepo extends JpaRepository<Auto, Long> {
	
	
	@Query("select s from Auto s  where s.dossier.idDossier = :idDossier")
	List<Auto> getContratAutoInDossier(@Param("idDossier") long idDossier);
	

}
