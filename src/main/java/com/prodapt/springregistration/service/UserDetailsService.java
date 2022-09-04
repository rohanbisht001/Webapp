package com.prodapt.springregistration.service;

import java.util.List;

import com.prodapt.springregistration.entities.UserDetails;

public interface UserDetailsService {
	//Create
	public UserDetails addUser(UserDetails userDetails);
	//Retrieve
	public UserDetails getUserById(Long id);
	
	//Update
	public UserDetails updateUser(UserDetails userDetails);
	
	//Delete
	public void deleteUserById(Long id);
	//retrieve by list 
	public List<UserDetails> getList();

}
