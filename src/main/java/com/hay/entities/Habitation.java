package com.hay.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Habitation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idContratHabitation;
	private String typeLogement;
	private int nbrPiece;
	private Date dateDebut;
	private Date dateFin;
	private String adresseHabitation;
	private String ville;
	private double montant;
	
	
	@ManyToOne
	@JoinColumn(name="idDossier")
	private Dossier dossier ;


	public long getIdContratHabitation() {
		return idContratHabitation;
	}


	public void setIdContratHabitation(long idContratHabitation) {
		this.idContratHabitation = idContratHabitation;
	}


	public String getTypeLogement() {
		return typeLogement;
	}


	public void setTypeLogement(String typeLogement) {
		this.typeLogement = typeLogement;
	}


	public int getNbrPiece() {
		return nbrPiece;
	}


	public void setNbrPiece(int nbrPiece) {
		this.nbrPiece = nbrPiece;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public String getAdresseHabitation() {
		return adresseHabitation;
	}


	public void setAdresseHabitation(String adresseHabitation) {
		this.adresseHabitation = adresseHabitation;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Dossier getDossier() {
		return dossier;
	}


	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	
	
	
	
	
	
	
	

}
