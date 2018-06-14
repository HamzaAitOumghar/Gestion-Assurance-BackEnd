package com.hay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hay.entities.RegisterForm;
import com.hay.entities.Utilisateur;

@RestController
public class AccountRest {

	@Autowired
	private AccountService accountrepo;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Utilisateur register(@RequestBody RegisterForm user) {
		if(!user.getPasword().equals( user.getRePassword())) {
			throw new RuntimeException("You Must Confirm Your Passs");
		}
		Utilisateur utilisateur =accountrepo.findUserbyUsername(user.getUsername());
		if(utilisateur!=null) {
			throw new RuntimeException("User Deja Existe");
		}
		Utilisateur userFinal=new Utilisateur();
		userFinal.setUsername(user.getUsername());
		userFinal.setPassword(user.getPasword());
	
		 this.accountrepo.saveUser(userFinal);
		this.accountrepo.addRoleToUser(userFinal.getUsername() , "CLIENT");
		return userFinal;
	}
	
	
}
