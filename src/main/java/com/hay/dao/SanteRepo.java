package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Sante;

public interface SanteRepo extends JpaRepository<Sante, Long> {

}
