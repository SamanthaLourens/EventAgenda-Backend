package app.controllerlayer;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.models.EvenementModel;
import app.servicelayer.IEvenementService;
import app.servicelayer.NaamPlaatsDatumService;

@RestController
public class EvenementController {
	
	@Autowired
	private IEvenementService iEvenementService;
	
	@Autowired NaamPlaatsDatumService naamPlaatsDatumService;
	
	@GetMapping("/api/evenement/all")
	public List<EvenementModel> findAll(){
		return this.iEvenementService.findAll();
	}

	@GetMapping("/api/evenement/{id}")
	public Optional<EvenementModel> findById(@PathVariable Long id) {
		return this.iEvenementService.findById(id);
	}
	
	@GetMapping("/api/evenement/zoek/{zoek}")
	public List<EvenementModel> ZoekEvenementen(@PathVariable String zoek) {
		return this.iEvenementService.getAllEvenementen(zoek);
	}
	
	@GetMapping("/api/evenement/naam/{naam}")
	public List<EvenementModel> findByNaam(@PathVariable String naam){
		return this.iEvenementService.findByNaam(naam);
	}
	
	@GetMapping("/api/evenement/plaats/{plaats}")
	public List<EvenementModel> findByPlaats(@PathVariable String plaats){
		return this.iEvenementService.findByPlaats(plaats);
	}
	
	@GetMapping("/api/evenement/datum/{datum}")
	public List<EvenementModel> findByDatum(@PathVariable LocalDate datum){
		return this.iEvenementService.findByDatum(datum);
	}
	
	
	@GetMapping("/api/evenement/plaatsofnaam/{plaatsofnaam}")
	public List<EvenementModel> ZoekNaarPlaatsOfNaam(@PathVariable String plaatsofnaam){
		return this.naamPlaatsDatumService.vindOpPlaatsNaam(plaatsofnaam);
	}
	
	@GetMapping("/api/evenement/plaatsofnaamendatum/{plaatsofnaam}/{datum}")
	public List<EvenementModel> ZoekNaarPlaatsNaamEnDatum(@PathVariable String naamPlaats){
		return this.naamPlaatsDatumService.vindOpPlaatsNaam(naamPlaats);
	}
	
	
	
	
	
	
	
	
	
	
	

	@PostMapping("/api/evenement/")
	public EvenementModel create(@RequestBody EvenementModel evenement) {
		return this.iEvenementService.create(evenement);
	}

	@PutMapping("/api/evenement/{id}")
	public boolean update(@PathVariable Long id, @RequestBody EvenementModel evenement) {
		this.iEvenementService.update(evenement);
		return true;
	}

	@DeleteMapping("/api/evenement/{id}")
	public boolean delete(@PathVariable Long id) {
		Optional<EvenementModel> optional = this.iEvenementService.findById(id);
		if (optional.isPresent()) {
			this.iEvenementService.delete(optional.get());
			return true;
			}
		return false;
	}

}


