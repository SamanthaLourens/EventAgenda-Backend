package app.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daolayer.IAgendaDao;
import app.models.Agenda;
import app.models.EvenementModel;
import app.models.PersonModel;
import java.time.LocalDate;



@Service
public class AgendaService implements IAgendaService{
	
	@Autowired
	private IAgendaDao iAgendaDao;

	@Override
	public Agenda findByUser(PersonModel user) {
		return this.iAgendaDao.findByUser(user);
	}
	
	@Override
	public List<Agenda> findByEvenement(String evenement){
		return this.iAgendaDao.findByEvenement(evenement);
	}
	
	@Override
	public Optional<Agenda> findById(Long id) {
		return this.iAgendaDao.findById(id);
	}
	
	@Override
	public void update(Agenda agenda) {
		this.iAgendaDao.save(agenda);
	}
	
	@Override
	public void create(Agenda agenda) {
		this.iAgendaDao.save(agenda);
	}
	
	@Override
	public List<Agenda> findAll(){
		return this.iAgendaDao.findAll();
	}

}
