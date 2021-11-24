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

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("peoples")
public class PeoplesREST {
	
	
	@Autowired
	private PeoplesDAO peoplesDAO;
	
	
	
	@GetMapping
	public ResponseEntity<List<Peoples>> getPeoples(){
		
		List<Peoples> peoples = peoplesDAO.findAll();
		
		return ResponseEntity.ok(peoples);	
	
	}

	@PostMapping
	public ResponseEntity<Peoples> createPeople(@RequestBody Peoples peoples){
		
		Peoples newPeoples = peoplesDAO.save(peoples);
		
		return ResponseEntity.ok(newPeoples);
		
	}
	
	@DeleteMapping(value="{id_person}")
	public ResponseEntity<Void> deletePeople(@PathVariable("id_person") Long id_person){
		
		peoplesDAO.deleteById(id_person);

		
		return ResponseEntity.ok(null);
		
	}
	
	
	@PutMapping
	public ResponseEntity<Peoples> updatePeople(@RequestBody Peoples people){
		
		Optional<Peoples> optionalPeople = peoplesDAO.findById(people.getId_person());
		
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
