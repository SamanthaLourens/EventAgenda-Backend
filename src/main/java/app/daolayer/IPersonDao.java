package app.daolayer;


import java.util.*;
import org.springframework.data.repository.CrudRepository;
import app.models.PersonModel;




public interface IPersonDao extends CrudRepository<PersonModel, Long>{
	
	public List<PersonModel> findByName(String naam);   
	
	public Optional<PersonModel> findById(Long id);
	
	public List<PersonModel> findAll();

	
}