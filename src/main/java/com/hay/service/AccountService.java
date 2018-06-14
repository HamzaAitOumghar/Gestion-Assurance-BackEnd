package com.hay.service;

import com.hay.entities.Role;
import com.hay.entities.Utilisateur;

public interface AccountService {

	public Utilisateur saveUser(Utilisateur utilisateur);
	public Role saveRole(Role role);
	public void addRoleToUser(String username,String roleName);
	 public Utilisateur findUserbyUsername(String username);
	
}
