package com.hay.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Vehicule implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idVehicule;
	private String matriculation;
	private String marque;
	private String puissance;
	private String usageVehicule;

	
	
	@ManyToOne
	@JoinColumn(name="idAuto")
	private Auto autoContrat;



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



	public String getPuissance() {
		return puissance;
	}



	public void setPuissance(String puissance) {
		this.puissance = puissance;
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
