package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.DossierRepo;
import com.hay.dao.HabitationRepo;
import com.hay.entities.Auto;
import com.hay.entities.Dossier;
import com.hay.entities.Habitation;

@RestController
@CrossOrigin("*")
public class HabitationRest {

	@Autowired
	private HabitationRepo repo;
	
	@Autowired
	private DossierRepo repoDossier;
	
	@RequestMapping(value="/habitation",method=RequestMethod.GET)
	public List<Habitation> getHabitation(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/habitation/ajouter/{idDossier}",method=RequestMethod.POST)
	public Habitation saveContatHabitation(@RequestBody Habitation service,@PathVariable("idDossier") long idDossier) {
		
		Dossier dossier =(Dossier) repoDossier.findById(idDossier).get();
		service.setDossier(dossier);
		return repo.save(service);
	}
	
	@RequestMapping(value="/habitation/{id}",method=RequestMethod.GET)
	public List<Habitation> getAllContratHabitationInDossier(@PathVariable("id") long idDossier){
		return repo.getContratHabitationInDossier(idDossier);
	}
	

	
	
	
	
	
}
