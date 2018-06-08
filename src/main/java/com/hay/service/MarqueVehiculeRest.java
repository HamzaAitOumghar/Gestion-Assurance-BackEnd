package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.MarqueVehiculeRepo;
import com.hay.entities.MarqueVehicule;

@RestController
@CrossOrigin("*")
public class MarqueVehiculeRest {
	
	@Autowired
	private MarqueVehiculeRepo repo;
	
	
	@RequestMapping(value="/MarqueVehicule",method=RequestMethod.GET)
	public List<MarqueVehicule> getMarque(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/MarqueVehicule/{name}",method=RequestMethod.GET)
	public MarqueVehicule getMarqueByName(@PathVariable("name") String name) {
		return repo.getMarqueVehiculeByName(name);
	}
	
	

}
