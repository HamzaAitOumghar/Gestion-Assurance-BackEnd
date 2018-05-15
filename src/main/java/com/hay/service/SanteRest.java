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
import com.hay.dao.SanteRepo;
import com.hay.entities.Dossier;
import com.hay.entities.Sante;
import com.hay.entities.Vehicule;

@RestController
@CrossOrigin("*")
public class SanteRest {

	
	@Autowired
	private SanteRepo repoSante;
	
	@Autowired
	private DossierRepo repoDossier;
	
	@RequestMapping(value="/Sante/ajouter/{idDossier}",method=RequestMethod.POST)
	public Sante saveSante(@RequestBody Sante service,@PathVariable("idDossier") long idDossier) {
		
		System.out.println("Test ! ! "+idDossier);
		Dossier dossier = (Dossier ) repoDossier.findById(idDossier).get();
		System.out.println("Test ! ! "+dossier.getStatus());

		service.setDossier(dossier);
		
		return  repoSante.save(service);
	}
	
	@RequestMapping(value="/Sante",method=RequestMethod.GET)
	public List<Sante> getAllContratSante(){
			return this.repoSante.findAll();
	}
	
	
	
	
}
