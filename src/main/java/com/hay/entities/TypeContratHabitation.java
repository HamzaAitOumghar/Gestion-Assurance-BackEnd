package com.hay.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TypeContratHabitation")
public class TypeContratHabitation implements Serializable {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypeContratHabitation;
	private String type;
	
	@ManyToMany(mappedBy="typeContrats")
	@JsonIgnore
	private List<Habitation> contratsAuto=new ArrayList<>();

	public int getIdTypeContratHabitation() {
		return idTypeContratHabitation;
	}

	public void setIdTypeContratHabitation(int idTypeContratHabitation) {
		this.idTypeContratHabitation = idTypeContratHabitation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Habitation> getContratsAuto() {
		return contratsAuto;
	}

	public void setContratsAuto(List<Habitation> contratsAuto) {
		this.contratsAuto = contratsAuto;
	}
	

	
}
