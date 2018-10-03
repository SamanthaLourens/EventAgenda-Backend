package app.dto;

import app.models.EvenementModel;




public class AgendaDto {
	
	private Long id;

	private EvenementModel evenement;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EvenementModel getEvenement() {
		return evenement;
	}

	public void setEvenement(EvenementModel evenement) {
		this.evenement = evenement;
	}


}
