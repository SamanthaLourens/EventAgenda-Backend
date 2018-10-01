package app.servicelayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.daolayer.IEvenementDao;
import app.models.EvenementModel;




@Service
public class NaamPlaatsDatumService {
	
	private IEvenementDao iEvenementDao;
	
	public List<EvenementModel> vindOpPlaatsNaam(String naamPlaats) {
		ArrayList<EvenementModel> evenementen = new ArrayList();  	
		
		for (EvenementModel event: this.iEvenementDao.findByNaam(naamPlaats) ) {
			evenementen.add(event);}
		for (EvenementModel event: this.iEvenementDao.findByPlaats(naamPlaats)) {
			evenementen.add(event);}
		

		return evenementen;
	}
	
	
	
	
	public List<EvenementModel> vindOpPlaatsNaamEnDatum(String naamPlaats, LocalDate datum){
		ArrayList<EvenementModel> evenementen = new ArrayList();  	
		
		for (EvenementModel event: this.iEvenementDao.findByNaam(naamPlaats)) {
			evenementen.add(event);}
		for (EvenementModel event: this.iEvenementDao.findByPlaats(naamPlaats)) {
			evenementen.add(event);}
		
		for (EvenementModel event: evenementen) {
			if (event.getDatum() != datum) {
				evenementen.remove(event);
			}
		}
		return evenementen;
	}
}
