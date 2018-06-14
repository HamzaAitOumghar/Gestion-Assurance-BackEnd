package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	
public Utilisateur findByUsername(String username);
	
}
