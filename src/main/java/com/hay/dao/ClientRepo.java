package com.hay.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {
	
	@Query(value="select  c.nom ,c.prenom,c.numTel,c.profession ,c.email  from Client c where c.idClient = :idClient")
	Object getClient(@Param("idClient") long idClient);

}
