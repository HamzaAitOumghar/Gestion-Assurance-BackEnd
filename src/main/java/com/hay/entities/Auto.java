package com.hay.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Auto implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date dateEffetPolice;
	private Date dateEchange;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Dossier dossier ;
	
	@OneToMany(mappedBy="auto")
	private List<Vehicule> vehicules; 
	
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateEffetPolice() {
		return dateEffetPolice;
	}
	public void setDateEffetPolice(Date dateEffetPolice) {
		this.dateEffetPolice = dateEffetPolice;
	}
	public Date getDateEchange() {
		return dateEchange;
	}
	public void setDateEchange(Date dateEchange) {
		this.dateEchange = dateEchange;
	}
	public Auto(Date dateEffetPolice, Date dateEchange) {
		super();
		this.dateEffetPolice = dateEffetPolice;
		this.dateEchange = dateEchange;
	}
	public Auto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
