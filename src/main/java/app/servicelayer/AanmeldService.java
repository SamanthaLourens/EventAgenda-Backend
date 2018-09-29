package app.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daolayer.IAgendaDao;
import app.daolayer.IPersonDao;
import app.models.Agenda;
import app.models.PersonModel;


//Bij deze Service wordt er een user gemaakt en een bijbehorende agenda


@Service
public class AanmeldService {
	
	@Autowired
	private IAgendaDao iAgendaDao;
		
	@Autowired
	private IPersonDao iPersonDao;
	
	
	// Bij het aanmaken van een account moet de user een naam en wachtwoord invoeren
	// Er wordt dan ook een agenda aangemaakt die aan de user wordt gekoppeld
	public PersonModel maakAccountAan(String naam, String wachtwoord) {
		PersonModel user = new PersonModel();
		user.setNaam(naam);
		user.setPassWord(wachtwoord);
		Agenda agenda = new Agenda();
		agenda.setUser(user);
		this.iPersonDao.save(user);
		this.iAgendaDao.save(agenda);
		return user;
	}
}
