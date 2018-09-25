package app.servicelayer;

import app.models.PersonModel;
import java.util.*;


public interface IPersonService {
	
	public List<PersonModel> findByName(String naam);
	
	public Optional<PersonModel> findById(Long id);
	
	public List<PersonModel> findAll();

	public PersonModel create(PersonModel person);

	void delete(PersonModel person);

	void update(PersonModel person);
	
}
