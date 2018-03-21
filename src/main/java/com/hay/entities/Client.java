package com.hay.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String numTel;
	private String profession;
	private String email;

	@OneToMany(mappedBy="client")
	private List<Dossier> dossiers;
	
	

	
}
