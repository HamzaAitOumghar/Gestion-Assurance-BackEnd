package com.hay.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


 @Entity
public class Role implements Serializable{
	
	 @Id
	private String roleUtilisateur ;
	private String description;
	
	@ManyToMany
	private List<Utilisateur> utilisateurs ;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String role, String description) {
		super();
		this.roleUtilisateur = role;
		this.description = description;
	}
	public String getRole() {
		return roleUtilisateur;
	}
	public void setRole(String role) {
		this.roleUtilisateur = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
