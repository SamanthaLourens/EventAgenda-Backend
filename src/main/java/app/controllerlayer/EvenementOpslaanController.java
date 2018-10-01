package app.controllerlayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Agenda;
import app.models.EvenementModel;
import app.models.PersonModel;
import app.servicelayer.AgendaService;
import app.servicelayer.EvenementService;
import app.servicelayer.SlaEvenementOpService;



@RestController
public class EvenementOpslaanController {
	
	@Autowired
	private SlaEvenementOpService slaEvenementOpService;

	@Autowired 
	private AgendaService agendaService;

	
	@PostMapping("/api/VoegToeAanAgenda/{eventId}/{agendaId}")
	public Optional<Agenda> voegToeAanAgenda(@PathVariable Long eventId, @PathVariable Long agendaId) {
		this.slaEvenementOpService.EvenementOpslaan(eventId, agendaId);
		return this.agendaService.findById(agendaId);
	}

}
