package com.jackrutorial.model;



import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Lieu {

	@Id
	@NotEmpty
	private String codeInsee;	
	
	private String nomCom;
	
	private double longitude;
	
	private double latitude;
	private String photo;
	
	//Dans un seul lieu se localise plusieurs monuments
	@OneToMany(mappedBy="codeLieu", fetch=FetchType.LAZY)
	private List<Monument> monuments;
	
	
	//plusieurs lieux sont  dans un seul departement !
	@ManyToOne
	@JoinColumn(name="dep")
	
	private Departement dep;
	
	


	public Lieu() {
		super();
	}


	public Lieu(String codeInsee, String nomCom, double longitude, double latitude, String photo,
			Departement dep) {
		super();
		this.codeInsee = codeInsee;
		this.nomCom = nomCom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.photo = photo;
		this.dep = dep;
	}


	


	public void setDep(Departement dep) {
		this.dep = dep;
	}


	public String getCodeInsee() {
		return codeInsee;
	}


	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}


	public String getNomCom() {
		return nomCom;
	}


	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public Departement getDepartement() {
		return dep;
	}


	public void setDepartement(Departement dep) {
		this.dep = dep;
	}
	
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Departement getDep() {
		return dep;
	}


	public List<Monument> getMonuments() {
		return monuments;
	}


	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

	
}
