package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Dossier;

public interface DossierRepo extends JpaRepository<Dossier, Long> {

}
