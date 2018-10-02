package app.servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daolayer.IAgendaDao;
import app.daolayer.IEvenementDao;
import app.daolayer.IPersonDao;
import app.dto.PersonDto;
import app.models.Agenda;
import app.models.EvenementModel;
import app.models.PersonModel;



@Service
public class VindEenMattieService {
	
	@Autowired
	private IPersonDao iPersonDao;
	
	@Autowired
	private IEvenementDao iEvenementDao;
	
	@Autowired
	private IAgendaDao iAgendaDao;
	
	
	//Deze methode geeft een lijst van personen terug die naar een bepaald evenement gaan
	public List<PersonModel> zoekPersonen(Long evenementId) {
		ArrayList<PersonModel> users = new ArrayList();
		Optional<EvenementModel> event = this.iEvenementDao.findById(evenementId);
		List<Agenda> AgendaLijst = this.iAgendaDao.findAll();
		if (event.isPresent()) {
			EvenementModel evenement = event.get();
			for (Agenda agenda: AgendaLijst) {
				if (agenda.getEvenement().contains(evenement)) {
					users.add(agenda.getUser());
				}
			}
		}
		return users;
	}
	
	
	// Roep deze functie aan om Dto's terug te krijgen ipv PersonModels
	// Door hier gebruik van te maken krijg je geen JSON's met wachtwoorden
	public List<PersonDto> zoekPersonDto(Long evenementId) {
		List<PersonModel> users = zoekPersonen(evenementId);
		List<PersonDto> userDtos = new ArrayList();
		for (PersonModel user:users) {
			PersonDto userDto = new PersonDto();
			userDto.setNaam(user.getNaam());
			userDto.setId(user.getId());
			userDtos.add(userDto);
		}
		return userDtos;
	}
}
