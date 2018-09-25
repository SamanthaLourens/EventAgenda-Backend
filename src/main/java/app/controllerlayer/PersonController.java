package app.controllerlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.servicelayer.*;
import app.models.*;
import java.util.*;



@RestController
public class PersonController {

	@Autowired
	private IPersonService iPersonService;
	
	
	@GetMapping("/api/person/all")
	public List<PersonModel> findAll(){
		return this.iPersonService.findAll();
	}
	
	@GetMapping("/api/person/name/{naam}")
	public List<PersonModel> findByName(@PathVariable String naam){
		return this.iPersonService.findByName(naam);
	}

	
	@GetMapping("/api/person/id/{id}")
	public Optional<PersonModel> findById(@PathVariable Long id){
		return this.iPersonService.findById(id);
	}
	

	@PostMapping("/api/person/")
	public PersonModel create(@RequestBody PersonModel person) {
		return this.iPersonService.create(person);
	}
	
	@PutMapping("/api/person/id/{id}")
	public boolean update(@PathVariable Long id, @RequestBody PersonModel person) {
		this.iPersonService.update(person);
		return true;
	}

	@DeleteMapping("/api/person/id/{id}")
	public boolean delete(@PathVariable Long id) {
		Optional<PersonModel> optional = this.iPersonService.findById(id);
		if (optional.isPresent()) {
			this.iPersonService.delete(optional.get());
			return true;
			}
		return false;
	}

}





