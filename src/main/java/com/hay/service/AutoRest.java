package com.hay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.AutoRepo;
import com.hay.entities.Auto;
import com.hay.entities.Client;

@RestController
@CrossOrigin("*")
public class AutoRest {
	
	@Autowired
	private AutoRepo repoAuto;

	
	@RequestMapping(value="/auto/ajouter",method=RequestMethod.POST)
	public Auto saveContatAuto(@RequestBody Auto service) {
		return repoAuto.save(service);
	}
	
}
