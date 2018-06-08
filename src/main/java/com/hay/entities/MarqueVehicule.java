package com.hay.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MarqueVehicule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idMarqueVehicule;
	private String marque;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="marqueVehicule")
	List<Vehicule> vehicules =new ArrayList<>();
	
	
	public long getIdMarqueVehicule() {
		return idMarqueVehicule;
	}
	public void setIdMarqueVehicule(long idMarqueVehicule) {
		this.idMarqueVehicule = idMarqueVehicule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	

}
