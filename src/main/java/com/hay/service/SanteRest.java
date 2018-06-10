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
		Dossier dossier = (Dossier ) repoDossier.findById(idDossier).get();
		service.setDossier(dossier);
		return  repoSante.save(service);
	}
	
	@RequestMapping(value="/Sante",method=RequestMethod.GET)
	public List<Sante> getAllContratSante(){
			return this.repoSante.findAll();
	}
	
	@RequestMapping(value="/Sante/{id}",method=RequestMethod.GET)
	public List<Sante> getAllContratSanteInDossier(@PathVariable("id") long idDossier){
			return this.repoSante.getContratSanteInDossier(idDossier);
	}
	
	
	@RequestMapping(value="/Sante/modifier/{id}",method=RequestMethod.PUT)
	public Sante modifierSante(@PathVariable("id") long idSante,@RequestBody Sante newSante) {
		Sante oldSante=(Sante)this.repoSante.findById(idSante).get();
		oldSante.setDateContrat(newSante.getDateContrat());
		oldSante.setMontant(newSante.getMontant());
		oldSante.setDateFinContrat(newSante.getDateFinContrat());
		return this.repoSante.save(oldSante);	
	}
	
	@RequestMapping(value="/Sante/delete/{id}",method=RequestMethod.DELETE)
	public Long deleteSante(@PathVariable("id") long idSante) {
		this.repoSante.deleteById(idSante);
		return idSante;
	}
	
	
	
}
