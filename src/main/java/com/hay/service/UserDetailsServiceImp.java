package com.hay.service;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hay.entities.Utilisateur;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private AccountService acountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user = acountService.findUserbyUsername(username);
		if(user==null) throw new UsernameNotFoundException("User Not Found !");
		Collection<GrantedAuthority> authorities =new ArrayList<>();
		user.getRoles().forEach(
				r->{
					authorities.add(new SimpleGrantedAuthority(r.getRole()));
				}
				);
		
		return new User(user.getUsername(),user.getPassword(),authorities);
	}

	
}
