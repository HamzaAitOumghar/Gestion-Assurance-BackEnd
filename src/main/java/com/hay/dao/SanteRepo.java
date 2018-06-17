package com.hay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Sante;

public interface SanteRepo extends JpaRepository<Sante, Long> {
	
	@Query("select s from Sante s   where s.dossier.idDossier = :idDossier")
	List<Sante> getContratSanteInDossier(@Param("idDossier") long idDossier);
	
	@Query("select  year(s.dateContrat), month(s.dateContrat ),count(s.numContratSante)   from Sante s   group by  year(s.dateContrat), month(s.dateContrat ) order by   year(s.dateContrat), month(s.dateContrat )  ")
	Object[]  getStatSante();

	@Query("select  year(s.dateContrat), month(s.dateContrat ),sum(s.montant)   from Sante s   group by  year(s.dateContrat), month(s.dateContrat ) order by   year(s.dateContrat), month(s.dateContrat )  ")
	Object[]  getBudgetSante();

}
