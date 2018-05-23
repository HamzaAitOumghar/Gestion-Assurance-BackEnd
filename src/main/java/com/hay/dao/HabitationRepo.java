package com.hay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Habitation;

public interface HabitationRepo extends JpaRepository<Habitation, Long> {

	@Query("select s from Habitation s  where s.dossier.idDossier = :idDossier")
	List<Habitation> getContratHabitationInDossier(@Param("idDossier") long idDossier);

}
