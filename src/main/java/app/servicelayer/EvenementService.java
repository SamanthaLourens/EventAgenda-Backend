package app.servicelayer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.daolayer.IEvenementDao;
import app.models.EvenementModel;

@Service
public class EvenementService implements IEvenementService {
	
	@Autowired
	private IEvenementDao iEvenementDao;

	
	@Override
	public List<EvenementModel> findAll(){
		return this.iEvenementDao.findAll();
	}

	@Override
	public Optional<EvenementModel> findById(Long id){
		return this.iEvenementDao.findById(id);
	}

	@Override
	public List<EvenementModel> findByPlaats(String plaats) {
		return this.iEvenementDao.findByPlaats(plaats);
	}

	@Override
	public List<EvenementModel> findByDatum(String datum) {
		return this.iEvenementDao.findByDatum(datum);
	}
	
	@Override
	public List<EvenementModel> findByNaam(String naam){
		return this.iEvenementDao.findByNaam(naam);
	}
	
	
	@Override
	public EvenementModel create(EvenementModel evenement) {
		return this.iEvenementDao.save(evenement);
	}
	
	@Override
	public void update(EvenementModel evenement) {
		this.iEvenementDao.save(evenement);
	}

	@Override
	public void delete(EvenementModel evenement) {
		this.iEvenementDao.delete(evenement);
	}

}
