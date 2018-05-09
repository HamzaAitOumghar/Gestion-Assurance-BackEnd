package com.hay.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Vehicule implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idVehicule;
	private String matriculation;
	private String marque;
	private Date datePremierMiseService;
	private int nbrPlace;
	private String usageVehicule;
	private int nbrChevaux;
	private String typeMoteur;
	
	
	@OneToOne
	@JoinColumn(name="idAuto")
	private Auto autoContrat;



	public int getNbrChevaux() {
		return nbrChevaux;
	}



	public void setNbrChevaux(int nbrChevaux) {
		this.nbrChevaux = nbrChevaux;
	}



	public String getTypeMoteur() {
		return typeMoteur;
	}



	public void setTypeMoteur(String typeMoteur) {
		this.typeMoteur = typeMoteur;
	}



	public Date getDatePremierMiseService() {
		return datePremierMiseService;
	}



	public void setDatePremierMiseService(Date datePremierMiseService) {
		this.datePremierMiseService = datePremierMiseService;
	}



	public long getIdVehicule() {
		return idVehicule;
	}



	public void setIdVehicule(long idVehicule) {
		this.idVehicule = idVehicule;
	}



	public String getMatriculation() {
		return matriculation;
	}



	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}



	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}







	public int getNbrPlace() {
		return nbrPlace;
	}



	public void setNbrPlace(int nbrPlace) {
		this.nbrPlace = nbrPlace;
	}



	public String getUsageVehicule() {
		return usageVehicule;
	}



	public void setUsageVehicule(String usageVehicule) {
		this.usageVehicule = usageVehicule;
	}



	public Auto getAutoContrat() {
		return autoContrat;
	}



	public void setAutoContrat(Auto autoContrat) {
		this.autoContrat = autoContrat;
	}



	
}
