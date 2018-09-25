package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonModel {
	
	private String name;
	
	private String passWord;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public void setId(Long id) {
		this.id = id; 
	}
	
	public Long getId() {
		return id;
	}

	public String getNaam() {
		return name;
	}

	public void setNaam(String naam) {
		this.name = naam;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getPassWord() {
		return this.passWord;
	}

	
}
