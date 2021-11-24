/**
 * 
 * @author Gabriel Romero
 * 
 * Clase donde se exponen todos los servicios REST utilizados
 *
 */
package com.bci.peopledata.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.peopledata.dao.PeoplesDAO;
import com.bci.peopledata.entitys.Peoples;


@RestController
@RequestMapping("/")
public class PeoplesREST {
	
	
	@Autowired
	private PeoplesDAO peoplesDAO;
	
	
	
	@GetMapping
	public ResponseEntity<List<Peoples>> getPeoples(){
		
		List<Peoples> peoples = peoplesDAO.findAll();
		
		return ResponseEntity.ok(peoples);	
		
/*		Peoples peoples = new Peoples();

		peoples.setName("Juan Rodriguez");
		peoples.setEmail("juan@rodriguez.org");
		peoples.setPassword("hunter2");
*/				

		
	}
	/*
	//@GetMapping
	public ResponseEntity<Phone> getPhones(){
		
		Phone phone = new Phone();
		
		phone.setNumber(1234567);
		phone.setCitycode(1);
		phone.setContrycode(57);
		
		return ResponseEntity.ok(phone);
		
	}
*/

	

}
