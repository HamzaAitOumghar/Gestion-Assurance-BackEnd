package com.hay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.ClientRepo;
import com.hay.dao.DossierRepo;
import com.hay.entities.Client;
import com.hay.entities.Dossier;


@RestController
@CrossOrigin("*")
public class DossierRest {
	
	@Autowired
	private DossierRepo repo;

	@Autowired
	private ClientRepo repoClient;

	
	@RequestMapping(value="/dossiers",method=RequestMethod.GET)
	public List<Dossier> getDossiers(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/dossiers/{id}",method=RequestMethod.GET)
	public Dossier getDossierById(@PathVariable("id") long id) {
		return (Dossier)repo.findById(id).get();
	}
	@RequestMapping(value="/dossiers/client/{id}",method=RequestMethod.GET)
	public Dossier getDossierByClientId(@PathVariable("id") long id) {
		return (Dossier)repo.findOneByClientId(id);
	}
	
	
	@RequestMapping(value="/dossiers/ajouter/{id}",method=RequestMethod.POST)
	public Dossier addDossiers(@RequestBody Dossier d,@PathVariable("id") long idClient){
		Client cl = (Client)repoClient.findById(idClient).get();
		d.setClient(cl);
		return repo.save(d);
	
	}
	
	@RequestMapping(value="/dossiers/modifier/{id}",method=RequestMethod.PUT)
	public Dossier modifierDossiers(@RequestBody Dossier d,@PathVariable("id") long idDossier){
		Dossier cl = (Dossier)repo.findById(idDossier).get();

		cl.setDateCreation(d.getDateCreation());
		cl.setNumero(d.getNumero());
		cl.setStatus(d.getStatus());
		
		
		return repo.save(cl);
	
	}
	
	
	@RequestMapping(value="/dossiers/detailsClient/{id}",method=RequestMethod.GET)
	public Object getClientDetails(@PathVariable  long id){
		return repoClient.getClient(id);
	}
	
	@RequestMapping(value="/dossiers/{id}",method=RequestMethod.DELETE)
	public void supprimertDossier(@PathVariable  long id){
			repo.deleteById(id); ;
	}
	
	
	
	
}
