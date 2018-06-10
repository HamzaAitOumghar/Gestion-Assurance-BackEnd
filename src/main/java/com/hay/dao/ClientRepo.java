package com.hay.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.Client;


public interface ClientRepo extends JpaRepository<Client, Long> {
	
	@Query(value="select  c.nom ,c.prenom,c.numTel,c.profession ,c.email  from Client c where c.idClient = :idClient")
	Object getClient(@Param("idClient") long idClient);

	@Query(value="select c.idClient  , c.nom +' '+c.prenom as nomComplet from Client c ")
	List<Object> getIdClient();
	
	@Query(value="select c.status.labelStatus as status  , count(c. idClient) as nombre  from Client as c  group by  c.status.labelStatus  ")
	 Object[] getStatusClient();
	
	
}
