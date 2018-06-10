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
import javax.persistence.Table;

@Entity
@Table(name="Sante")
public class Sante implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numContratSante;
	private Date dateContrat;
	private Date dateFinContrat ;
	private double montant;
	
	@ManyToOne
	private Dossier dossier;
	
	@ManyToMany
	@JoinTable(name="TypesSante",joinColumns=@JoinColumn(name="numContratSante"),inverseJoinColumns=@JoinColumn(name="idTypeContratSante"))
	List<TypeContratSante> typeContrats=new ArrayList<>();
	
	
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
	
	
	public Date getDateFinContrat() {
		return dateFinContrat;
	}
	public void setDateFinContrat(Date dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}
	public List<TypeContratSante> getTypeContrats() {
		return typeContrats;
	}
	public void setTypeContrats(List<TypeContratSante> typeContrats) {
		this.typeContrats = typeContrats;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
	
	
}
