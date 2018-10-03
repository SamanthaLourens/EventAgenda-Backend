package app.servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daolayer.IAgendaDao;
import app.daolayer.IEvenementDao;
import app.models.Agenda;
import app.models.EvenementModel;




@Service
public class SlaEvenementOpService {
	
	@Autowired
	private IAgendaDao iAgendaDao;
	
	@Autowired
	private IEvenementDao iEvenementDao;
	

	
	public boolean EvenementOpslaan(Long evenementId, Long agendaId) {
		Optional<EvenementModel> event = this.iEvenementDao.findById(evenementId);
		Optional<Agenda> agenda = this.iAgendaDao.findById(agendaId);
		
		if (event.isPresent() && agenda.isPresent()) {
			Agenda a = agenda.get();
			EvenementModel evenement = event.get();
			a.getEvenement().add(evenement);  //returnt een ArrayList en voegt er dan een evenement aan toe
			this.iAgendaDao.save(a);   //Slaat de nieuwe lijst met evenementen op
			return true;
		}else return false;
	}
	
	 

}
