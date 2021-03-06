package com.hay.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Auto implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idAuto;
	private Date dateEffetPolice;
	private Date dateEchange;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="idDossier")
	private Dossier dossier ;
	
	@OneToOne(mappedBy="autoContrat")
	private Vehicule vehicules;
	
	@ManyToMany
	@JoinTable(name="TypesAuto",joinColumns=@JoinColumn(name="idAuto"),inverseJoinColumns=@JoinColumn(name="idTypeContratAuto"))
	List<TypeContratAuto> typeContrats=new ArrayList<>();
	
	
	

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public long getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(long idAuto) {
		this.idAuto = idAuto;
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

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public Vehicule getVehicules() {
		return vehicules;
	}

	public void setVehicules(Vehicule vehicules) {
		this.vehicules = vehicules;
	}

	public List<TypeContratAuto> getTypeContrats() {
		return typeContrats;
	}

	public void setTypeContrats(List<TypeContratAuto> typeContrats) {
		this.typeContrats = typeContrats;
	}

	
	
	
	
}
