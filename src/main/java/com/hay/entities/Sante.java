package com.hay.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Sante")
public class Sante implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numContratSante;
	private Date dateContrat;
	private String status ;
	private double montant;
	
	@ManyToOne
	private Dossier dossier;
	
	
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	public long getNumContratSante() {
		return numContratSante;
	}
	public void setNumContratSante(long numContratSante) {
		this.numContratSante = numContratSante;
	}
	public Date getDateContrat() {
		return dateContrat;
	}
	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	
	
}
