package com.hay.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hay.dao.RoleRepo;
import com.hay.dao.UtilisateurRepo;
import com.hay.entities.Role;
import com.hay.entities.Utilisateur;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bycptPassword;
	@Autowired	
	private UtilisateurRepo repoUtil;
	@Autowired
	private RoleRepo repoRole;
	
	@Override
	public Utilisateur saveUser(Utilisateur utilisateur) {
		String hashPW=this.bycptPassword.encode(utilisateur.getPassword());
		utilisateur.setPassword(hashPW);
		return repoUtil.save(utilisateur);
	}

	@Override
	public Role saveRole(Role role) {
		return this.repoRole.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {	
			Role role=repoRole.findByRole(roleName);
			Utilisateur utilisateur=repoUtil.findByUsername(username);
			utilisateur.getRoles().add(role);
	}

	@Override
	public Utilisateur findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		return repoUtil.findByUsername(username);
	}

	
}
