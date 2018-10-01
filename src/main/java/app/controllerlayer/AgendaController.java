package app.controllerlayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Agenda;
import app.servicelayer.IAgendaService;



@RestController
public class AgendaController {
	
	@Autowired
	private IAgendaService iAgendaService;
	
	
	@GetMapping("/api/agenda/all")   //Deze heb ik gemaakt voor mezelf om te controleren of agenda's goed worden
	public List<Agenda> findAll(){     //opgeslagen
		return this.iAgendaService.findAll();
	}
}
