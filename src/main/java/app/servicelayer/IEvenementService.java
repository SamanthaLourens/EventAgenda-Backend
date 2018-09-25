package app.servicelayer;

import java.util.*;

import app.models.EvenementModel;

public interface IEvenementService {

	Optional<EvenementModel> findById(Long id);
	
	List<EvenementModel> findAll();
	
	List<EvenementModel> findByPlaats(String plaats);
	
	List<EvenementModel> findByDatum(String datum);
	
	List<EvenementModel> findByNaam(String naam);
	
	EvenementModel create(EvenementModel evenement);
	
	void update(EvenementModel evenement);
	
	void delete(EvenementModel evenement);
	
	 
}
