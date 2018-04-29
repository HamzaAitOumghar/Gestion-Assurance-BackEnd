package com.hay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hay.entities.Dossier;

public interface DossierRepo extends JpaRepository<Dossier, Long> {

	
	@Query(value="select d.idDossier ,d.numero,d.status,d.dateCreation,d.client.idClient  from Dossier d")
	List<Dossier> getDossiers();
	
}
