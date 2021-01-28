package com.Dict.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Acronyms")
public class Acronyms 
{
 @Id
 private String acronym;
 private String fullform;
public String getAcronym() {
	return acronym;
}
public void setAcronym(String acronym) {
	this.acronym = acronym;
}
public String getFullform() {
	return fullform;
}
public void setFullform(String fullform) {
	this.fullform = fullform;
}
 
}
