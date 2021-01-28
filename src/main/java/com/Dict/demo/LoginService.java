package com.Dict.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService 
{
	@Autowired
	RestRepository repository;
	
	public String verify(String userid, String pwd)
	{
		if(repository.existsById(userid))
		{
			return "AcronymSearch";
		}
		return "Login";
	}

}
