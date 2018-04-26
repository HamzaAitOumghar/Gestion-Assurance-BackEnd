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
import com.hay.entities.Client;

@RestController
@CrossOrigin("*")
public class ClientRest {

	@Autowired
	private ClientRepo repo;
	
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> getClient(){
		return repo.findAll();
	}
	
	@RequestMapping(value="/ajouterClient",method=RequestMethod.POST)
	public Client ajouterClient(Client c) {
		return this.repo.save(c);
	}
	
	@RequestMapping(value = "clients/{id}", method = RequestMethod.DELETE)
	public String deleteClient(@PathVariable("id") long clientId) {
		this.repo.deleteById(clientId);
	    return "redirect:/client";
	}
	
	@RequestMapping(value = "clients/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable("id") long clientId) {
		return this.repo.getOne(clientId);
	     
	}
	@RequestMapping(value = "clients/{id}", method = RequestMethod.PUT)
	public Client editClient(@PathVariable("id") long clientId, @RequestBody Client cl) {

		Client c=this.repo.findById(clientId).get();
		System.out.println(cl.getNom());
		c.setAdresse(cl.getAdresse());
		c.setEmail(cl.getEmail());
		c.setNom(cl.getNom());
		c.setNumTel(cl.getNumTel());
		c.setPrenom(cl.getPrenom());
		c.setProfession(cl.getProfession());
		this.repo.save(c);
		return c;
		
	}
}
