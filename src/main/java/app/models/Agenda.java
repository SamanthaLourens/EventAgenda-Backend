package app.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	private List<EvenementModel> evenement;
	
	@OneToOne
	private PersonModel user;
	
	
	public PersonModel getUser() {
		return user;
	}

	public void setUser(PersonModel user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public List<EvenementModel> getEvenement() {
		return evenement;
	}

	public void setEvenement(ArrayList<EvenementModel> evenement) {
		this.evenement = evenement;
	}
	

}
