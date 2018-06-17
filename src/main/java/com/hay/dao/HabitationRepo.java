package com.hay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Habitation;

public interface HabitationRepo extends JpaRepository<Habitation, Long> {

	@Query("select s from Habitation s  where s.dossier.idDossier = :idDossier")
	List<Habitation> getContratHabitationInDossier(@Param("idDossier") long idDossier);

	@Query("select  year(s.dateDebut), month(s.dateDebut ),count(s.idContratHabitation)   from Habitation s   group by  year(s.dateDebut), month(s.dateDebut) order by   year(s.dateDebut), month(s.dateDebut)   ")
	Object[]  getStatHabitation();
	
	@Query("select  year(s.dateDebut), month(s.dateDebut ),sum(s.montant)   from Habitation s   group by  year(s.dateDebut), month(s.dateDebut) order by   year(s.dateDebut), month(s.dateDebut)   ")
	Object[]  getBudgetHabitation();
	
	
}
