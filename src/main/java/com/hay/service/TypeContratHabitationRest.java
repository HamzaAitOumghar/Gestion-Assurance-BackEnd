package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.TypeContratHabitationRepo;
import com.hay.entities.TypeContratHabitation;

@RestController
@CrossOrigin("*")
public class TypeContratHabitationRest {

	@Autowired
	private TypeContratHabitationRepo repo;
	
	
	@RequestMapping(value="/TypeHabitation",method=RequestMethod.GET)
	public List<TypeContratHabitation> getAllContratAutoTypes(){
		return repo.findAll();
	}
	
	
	
}
