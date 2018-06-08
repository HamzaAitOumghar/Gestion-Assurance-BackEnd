package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.StatusClientRepo;
import com.hay.entities.StatusClient;

@RestController
@CrossOrigin("*")
public class StatusClientRest {

	@Autowired
	private StatusClientRepo repo;
	
	
	@RequestMapping(value="/StatusClients",method=RequestMethod.GET)
	List<StatusClient> getAllStatusClient(){
		return this.repo.findAll();
	}
	
	@RequestMapping(value="/StatusClients/{label}",method=RequestMethod.GET)
	StatusClient getStatusbyLabel(@PathVariable("label") String label) {
		return this.repo.getStatusByLabe(label);
	}
	
	
	
	
}
