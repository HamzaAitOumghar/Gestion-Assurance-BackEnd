package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.StatusClient;

public interface StatusClientRepo extends JpaRepository<StatusClient, Long>{
	
	@Query("select s from StatusClient s  where s.labelStatus = :label ")
	StatusClient getStatusByLabe(@Param("label") String label);

}
