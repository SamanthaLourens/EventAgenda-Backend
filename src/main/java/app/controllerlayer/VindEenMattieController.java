package app.controllerlayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import app.dto.PersonDto;
import app.models.Agenda;
import app.models.PersonModel;
import app.servicelayer.VindEenMattieService;



@RestController
public class VindEenMattieController {
	
	@Autowired
	private VindEenMattieService vindEenMattieService;
		
	@GetMapping("/api/VindEenMattie/{eventId}")
	public List<PersonDto> vindIemand(@PathVariable Long eventId) {
		return this.vindEenMattieService.zoekPersonDto(eventId);
	}
	
}
