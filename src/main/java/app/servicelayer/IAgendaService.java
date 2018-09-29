package app.servicelayer;

import java.util.List;
import java.util.Optional;

import app.models.Agenda;
import app.models.PersonModel;



public interface IAgendaService {
	

	void update(Agenda agenda); //Hiermee kun je agenda updaten = evenementen toevoegen/verwijderen
	
	void create(Agenda agenda); //Hiermee kan gebruiker voor het eerst een agenda aanmaken
	
	public Agenda findByUser(PersonModel user);  //Hiermee kan agenda van user gevonden worden
		
	public List<Agenda> findByEvenement(String evenement);
	
	public Optional<Agenda> findById(Long id);
	
	public List<Agenda> findAll();
	
}
