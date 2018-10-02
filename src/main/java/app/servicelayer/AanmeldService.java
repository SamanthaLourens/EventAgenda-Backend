package app.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
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
	public boolean maakAccountAan(String naam, String wachtwoord) {
		if (this.iPersonDao.findByName(naam).size() == 0) { //Als er nog geen gebruiker is met deze naam
			PersonModel user = new PersonModel();    // dan mag je een account aanmaken met deze naam
			user.setNaam(naam);
			user.setPassWord(wachtwoord);
			Agenda agenda = new Agenda();   // maak er ook maar gelijk een agendaatje bij
			agenda.setUser(user);
			this.iPersonDao.save(user);
			this.iAgendaDao.save(agenda);
			return true;}
		else { return false; }
		
	}
	
	
	//Bij het inloggen wordt gecontroleerd of er een user is met deze naam en indien deze bestaat
	// of het ingevoerde wachtwoord gelijk is aan het wachtwoord dat bij deze user hoort
	public long inloggen(String naam, String wachtwoord) {
		List<PersonModel> user = this.iPersonDao.findByName(naam);
		if (user.size()>0 && user.get(0).getPassWord().equals(wachtwoord)) {
			return user.get(0).getId();
		}else return 0;
		
	}
	
}
