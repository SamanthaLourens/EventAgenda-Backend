package app.daolayer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.models.EvenementModel;

public interface IEvenementDao extends CrudRepository<EvenementModel, Long> {

	List<EvenementModel> findAll();
	
	List<EvenementModel> findByPlaats(String plaats);
	
	List<EvenementModel> findByDatum(String datum);
	
	List<EvenementModel> findByNaam(String naam);
	
}
