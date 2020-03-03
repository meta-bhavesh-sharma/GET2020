package com.metacube.training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.model.commands.UserCommands;
import com.metacube.training.model.commands.UserData;
import com.metacube.training.repository.UserRepo;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		
		Optional<UserCommands> userCommands = userRepo.findByEmail(email);
		
		userCommands.ifPresent(Employee -> {
		    System.out.println("User's is here ss = " + userCommands.get().getRole());   });
		
		userCommands.orElseThrow( () -> new UsernameNotFoundException( "Not found " + email));
		
		return userCommands.map(UserData::new).get();

	}
	

}
