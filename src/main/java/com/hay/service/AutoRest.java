package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.AutoRepo;
import com.hay.dao.DossierRepo;
import com.hay.entities.Auto;
import com.hay.entities.Client;
import com.hay.entities.Dossier;

@RestController
@CrossOrigin("*")
public class AutoRest {
	
	@Autowired
	private AutoRepo repoAuto;

	@Autowired
	private DossierRepo repoDossier;
	
	@RequestMapping(value="/auto/ajouter/{idDossier}",method=RequestMethod.POST)
	public Auto saveContatAuto(@RequestBody Auto service,@PathVariable("idDossier") long idDossier) {
		
		Dossier dossier =(Dossier) repoDossier.findById(idDossier).get();
		service.setDossier(dossier);
		return repoAuto.save(service);
	}
	
	@RequestMapping(value="/auto",method=RequestMethod.GET)
	public List<Auto> getAllContratAuto(){
		return repoAuto.findAll();
	}
	

	@RequestMapping(value="/auto/{id}",method=RequestMethod.GET)
	public List<Auto> getAllContratAutoInDossier(@PathVariable("id") long idDossier){
		return repoAuto.getContratAutoInDossier(idDossier);
	}

	
	@RequestMapping(value = "/auto/modifier/{id}", method = RequestMethod.PUT)
	public Auto editAuto(@PathVariable("id") long autoId, @RequestBody Auto au) {
		Auto newAuto=(Auto)repoAuto.findById(autoId).get();
		newAuto.setDateEchange(au.getDateEchange());
		newAuto.setDateEffetPolice(au.getDateEffetPolice());
		newAuto.setMontant(au.getMontant());
		newAuto.setTypeContrats(au.getTypeContrats());
		return repoAuto.save(newAuto);
	}
	
	@RequestMapping(value = "/auto/delete/{id}", method = RequestMethod.DELETE)
	public Long deleteAuto(@PathVariable("id") long idAuto) {
		 repoAuto.deleteById(idAuto);
		 return idAuto;
	}
	
	
	
	
}
