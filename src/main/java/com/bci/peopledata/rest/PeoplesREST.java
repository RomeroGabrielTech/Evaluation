/**
 * 
 * @author Gabriel Romero
 * 
 * Clase donde se exponen todos los servicios REST utilizados
 *
 */
package com.bci.peopledata.rest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.peopledata.dao.PeoplesDAO;
import com.bci.peopledata.entitys.Peoples;


@RestController
@RequestMapping("/")
public class PeoplesREST {
	
		
	@Autowired
	PeoplesDAO peoplesDAO;
	
	@PostMapping("/save")
	public ResponseEntity<Peoples> createPeople(@RequestBody Peoples peoples){
		
		Peoples newPeople = peoplesDAO.save(peoples);

		return ResponseEntity.ok(newPeople);
	}
	

	@GetMapping("/allPeople")
	public ResponseEntity<List<Peoples>> getPeoples(){
		
		List<Peoples> peoples = peoplesDAO.findAll();
		
		//return new ResponseEntity<List<Peoples>>(HttpStatus.OK);
		return ResponseEntity.ok(peoples);	
	
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deletePeople(@PathVariable("id") UUID id){
		
		peoplesDAO.hashCode();
		
		return ResponseEntity.ok(null);
		
	}
	
	
	@PutMapping(value="{id}")
	public ResponseEntity<Peoples> updatePeople(@RequestBody Peoples people){
		
		Optional<Peoples> optionalPeople = peoplesDAO.findById(people.getId());
		
		if(optionalPeople.isPresent()) {
			
			Peoples updatePeople = optionalPeople.get();
			updatePeople.setName(people.getName());
			peoplesDAO.save(updatePeople);
			return ResponseEntity.ok(updatePeople);
			
		}else {
			
			return ResponseEntity.notFound().build();
			
		}

	}
	

}
