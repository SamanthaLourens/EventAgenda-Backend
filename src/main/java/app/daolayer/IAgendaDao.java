package app.daolayer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.models.Agenda;
import app.models.EvenementModel;
import app.models.PersonModel;




public interface IAgendaDao extends CrudRepository<Agenda, Long>{
	
	// Deze staan ook al in de crudrepository
	
	Optional<Agenda> findById(Long id);      // Vindt de Agenda bij desbetreffende Id
	
	Agenda findByUser(PersonModel user);		//Vindt de agenda van desbetreffende user 
	
	List<Agenda> findByEvenement(String evenement); //Vindt alle agenda's om daarna desbetreffende
								//gebruikers die een bepaald evenement gepland hebben
	
	
	List<Agenda> findAll(); //In de crudrepository staat iterable dus ik zet het er hier bij
}
