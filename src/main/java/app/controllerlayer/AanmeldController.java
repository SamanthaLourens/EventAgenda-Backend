package app.controllerlayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.PersonModel;
import app.servicelayer.AanmeldService;



@RestController
public class AanmeldController {

		@Autowired
		private AanmeldService aanmeldService;
		
		@PostMapping("/api/aanmelden/{naam}/{wachtwoord}")
		public PersonModel MeldUserAan(@PathVariable String naam, @PathVariable String wachtwoord) {
			return this.aanmeldService.maakAccountAan(naam, wachtwoord);
		}
	
	
}
