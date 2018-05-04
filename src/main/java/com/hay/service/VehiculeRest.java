package com.hay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.VehiculeRepo;
import com.hay.entities.Vehicule;

@RestController
@CrossOrigin("*")
public class VehiculeRest {

	@Autowired
	private VehiculeRepo repoVehicule;
	
	@RequestMapping(value="/Vehicule/ajouter",method=RequestMethod.POST)
	public Vehicule saveVehiculeAuto(@RequestBody Vehicule service) {
		return  repoVehicule.save(service);
	}
	
	
	
}
