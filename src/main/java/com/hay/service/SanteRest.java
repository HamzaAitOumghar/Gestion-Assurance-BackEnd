package com.hay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.SanteRepo;
import com.hay.entities.Sante;
import com.hay.entities.Vehicule;

@RestController
@CrossOrigin("*")
public class SanteRest {

	
	@Autowired
	private SanteRepo repoSante;
	
	@RequestMapping(value="/Sante/ajouter",method=RequestMethod.POST)
	public Sante saveSante(@RequestBody Sante service) {
		return  repoSante.save(service);
	}
	
	
	
	
}
