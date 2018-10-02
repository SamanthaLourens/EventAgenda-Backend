package app.controllerlayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import app.models.Agenda;
import app.models.EvenementModel;
import app.servicelayer.IAgendaService;



@RestController
public class AgendaController {
	
	@Autowired
	private IAgendaService iAgendaService;
	
	
	@GetMapping("/api/agenda/all")   //Deze heb ik gemaakt voor mezelf om te controleren of agenda's goed worden
	public List<Agenda> findAll(){     //opgeslagen
		return this.iAgendaService.findAll();
	}
	
	
	// Hiermee kan de agenda van bepaalde user worden opgevraagd door middel van id
	@GetMapping("/api/agenda/{id}")
	public List<EvenementModel> findById(@PathVariable Long id){
		Optional<Agenda> agenda = this.iAgendaService.findById(id);
		if (agenda.isPresent()) {
		return agenda.get().getEvenement();
		}else return null;
	}
}
