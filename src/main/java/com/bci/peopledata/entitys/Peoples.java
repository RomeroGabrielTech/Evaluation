package com.bci.peopledata.entitys;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="persons")
public class Peoples{

	@Id
	@Column(name="id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_person;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")	
	private String email;
	
	@Column(name="password")	
	private String password;


	

	


	
	
	
	
	

}
