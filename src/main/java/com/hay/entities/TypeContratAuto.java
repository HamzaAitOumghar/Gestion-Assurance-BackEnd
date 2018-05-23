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
@Table(name="TypeContratAuto")
public class TypeContratAuto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypeContratAuto;
	private String type;
	
	@ManyToMany(mappedBy="typeContrats")
	@JsonIgnore
	private List<Auto> contratsAuto=new ArrayList<>();

	public int getIdTypeContratAuto() {
		return idTypeContratAuto;
	}

	public void setIdTypeContratAuto(int idTypeContratAuto) {
		this.idTypeContratAuto = idTypeContratAuto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Auto> getContratsAuto() {
		return contratsAuto;
	}

	public void setContratsAuto(List<Auto> contratsAuto) {
		this.contratsAuto = contratsAuto;
	}
	

	
	
}
