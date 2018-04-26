package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Vehicule;

public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {

}
