package com.Dict.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegisterService 
{
	@Autowired
	RestRepository repository;
	
	public void addUser(Users user)
	{
		
		Users newUser = repository.save(user);
		
	}
	
	
}
