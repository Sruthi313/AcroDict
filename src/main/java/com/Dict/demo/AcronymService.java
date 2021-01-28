package com.Dict.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class AcronymService 
{
	@Autowired
	JdbcTemplate jdbc;
	
	public String search(String acronym)
	{
		String sql = "select fullform from Acronyms where acronym = ?";
		String word = acronym.toUpperCase();
		String result=jdbc.queryForObject(sql, new Object[] {word}, String.class);
		return result;

	}
	
	

}
