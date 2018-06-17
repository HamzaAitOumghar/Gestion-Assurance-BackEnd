package com.hay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.dao.ClientRepo;
import com.hay.entities.Client;
import com.hay.entities.Utilisateur;

@RestController
public class AccountRest {
	
	@Autowired
	private BCryptPasswordEncoder bycptPassword;
	@Autowired
	private AccountService accountrepo;
	@Autowired
	private ClientRepo repoClient;
	
	
	@RequestMapping(value="/register/{idClient}",method=RequestMethod.POST)
	public Utilisateur register(@RequestBody Utilisateur user,@PathVariable("idClient") long idClient) {
		
		System.out.println("username"+user.getUsername()+"| password : "+user.getPassword());
		
		Client client=this.repoClient.findById(idClient).get();
		
		Utilisateur utilisateur =accountrepo.findUserbyUsername(user.getUsername());
		if(utilisateur!=null) {
			throw new RuntimeException("Identifiant deja existant");
		}
		
		Utilisateur userFinal=new Utilisateur();
		
		userFinal.setUsername(user.getUsername());
		String hashPW=this.bycptPassword.encode(user.getPassword());
		userFinal.setPassword(hashPW);
		userFinal.setClient(client);
		
		 this.accountrepo.saveUser(userFinal);
		 this.accountrepo.addRoleToUser(userFinal.getUsername() , "CLIENT");
		
		 return userFinal;
		
	}
	
	@RequestMapping(value="/userClient/{username}",method=RequestMethod.GET)
	public Utilisateur getClientUser(@PathVariable("username") String username) {
		Utilisateur user=this.accountrepo.findUserbyUsername(username);
		return user;
	}
	
	
}
