package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.TypeContratAutoRepo;
import com.hay.entities.TypeContratAuto;

@RestController
@CrossOrigin("*")
public class TypeContratAutoRest {

	
	@Autowired
	private TypeContratAutoRepo repo;
	
	@RequestMapping(value="/TypeAuto",method=RequestMethod.GET)
	public List<TypeContratAuto> getAllContratAutoTypes(){
		return repo.findAll();
	}
	
	
	
	
	
}
