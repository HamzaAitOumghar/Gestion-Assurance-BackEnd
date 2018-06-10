package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.TypeContratSanteRepo;
import com.hay.entities.TypeContratSante;

@RestController
@CrossOrigin("*")
public class TypeContratSanteRest {

	
	@Autowired
	private TypeContratSanteRepo repo;
	
	@RequestMapping(value="/TypeSante",method=RequestMethod.GET)
	public List<TypeContratSante> getAllContratAutoTypes(){
		return this.repo.findAll();
	}
	
	
}
