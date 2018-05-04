package com.hay.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Dossier implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idDossier ;
	private long numero;
	private String status;
	private Date dateCreation ;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(mappedBy="dossier")
	private List<Auto> autos;

	@OneToMany(mappedBy="dossier")
	private List<Sante> contratSantes;

	
	@ManyToOne
	@JoinColumn(name="username")
	private Utilisateur utilisateurDossier;

	public long getId() {
		return idDossier;
	}

	public void setId(long id) {
		this.idDossier = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Dossier(long numero, String status, Date dateCreation, Client client) {
		super();
		this.numero = numero;
		this.status = status;
		this.dateCreation = dateCreation;
		this.client = client;
	}

	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
}
