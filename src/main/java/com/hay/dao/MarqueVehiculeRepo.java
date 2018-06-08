package com.hay.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hay.entities.MarqueVehicule;

public interface MarqueVehiculeRepo extends JpaRepository<MarqueVehicule, Long> {
	@Query("select s from MarqueVehicule  s  where s.marque = :marque")
	MarqueVehicule getMarqueVehiculeByName(@Param("marque") String name);


}
