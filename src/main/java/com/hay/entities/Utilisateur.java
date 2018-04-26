package com.hay.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur implements Serializable {

	
	@Id
	private String username;
	private String password;


	@OneToMany(mappedBy="utilisateurDossier")
	private List<Dossier> dossiers;
	
	public Utilisateur( String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
}
