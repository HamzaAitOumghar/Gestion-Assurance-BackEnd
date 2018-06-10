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
@Table(name="TypeContratSante")
public class TypeContratSante implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypeContratSante;
	private String type;
	
	@ManyToMany(mappedBy="typeContrats")
	@JsonIgnore
	private List<Sante> contratsAuto=new ArrayList<>();

	public int getIdTypeContratSante() {
		return idTypeContratSante;
	}

	public void setIdTypeContratSante(int idTypeContratSante) {
		this.idTypeContratSante = idTypeContratSante;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Sante> getContratsAuto() {
		return contratsAuto;
	}

	public void setContratsAuto(List<Sante> contratsAuto) {
		this.contratsAuto = contratsAuto;
	}
	
	
	
	
}
