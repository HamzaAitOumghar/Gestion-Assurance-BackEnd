package com.hay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hay.dao.AutoRepo;
import com.hay.dao.RoleRepo;
import com.hay.entities.Role;
import com.hay.entities.Utilisateur;
import com.hay.service.AccountService;

@SpringBootApplication
public class Pfa1Application  implements CommandLineRunner{

	@Autowired
	private AccountService service;

	@Autowired
	private AutoRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(Pfa1Application.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
	
		System.out.println(this.repo.statMontantContrat());
		/*	
	Utilisateur user=new Utilisateur();
    user.setUsername("HAMZA2");
    user.setPassword("HAMZA");
    List<Role> roles=new ArrayList<>();
    roles.add(this.repo.findByRole("CLIENT"));
    user.setRoles(roles);    
	this.service.saveUser(user); */
	
//		this.service.addRoleToUser(user.getUsername(),"CLIENT");
//	Utilisateur user =this.service.findUserbyUsername("Hamza");
//	Role role= new Role();
//	role.setRole("ADMIN");
//	this.service.saveRole(role);
//	this.service.addRoleToUser(user.getUsername(),role.getRole());
////		user.setUsername("Hamza");
////		user.setPassword("hamza");
////		this.service.saveUser(user);
	}
	
}
