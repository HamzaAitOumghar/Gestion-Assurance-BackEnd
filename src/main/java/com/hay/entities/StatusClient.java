package com.hay.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StatusClient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idStatusClient;
	private String labelStatus;
	
	@OneToMany(mappedBy="status")
	private List<Client> client;
	
	public long getIdStatusClient() {
		return idStatusClient;
	}
	public void setIdStatusClient(long idStatusClient) {
		this.idStatusClient = idStatusClient;
	}
	public String getLabelStatus() {
		return labelStatus;
	}
	public void setLabelStatus(String labelStatus) {
		this.labelStatus = labelStatus;
	}
	
	
	

}
