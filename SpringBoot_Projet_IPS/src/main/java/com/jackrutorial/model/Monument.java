package com.jackrutorial.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class Monument {

	@Id
	private String codeM;
	private String nomM;
	private String proprietaire;
	private String typeMonument;
	private double longitude;
	private double latitude;
	
	@ManyToMany
	private List<Celebrite> celebrites;
	
	//plusieurs monuments sont localisé dans un seul lieu !
	@ManyToOne
	@JoinColumn(name="codeInsee")
	private Lieu codeLieu;
	




	


	public Monument() {
		super();
	}


	public Monument(String codeM, String nomM, String proprietaire, String typeMonument, double longitude,
			double latitude, Lieu codelieu) {
		super();
		this.codeM = codeM;
		this.nomM = nomM;
		this.proprietaire = proprietaire;
		this.typeMonument = typeMonument;
		this.longitude = longitude;
		this.latitude = latitude;
		this.codeLieu = codelieu; 
	}


	public String getCodeM() {
		return codeM;
	}


	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}


	public String getNomM() {
		return nomM;
	}


	public void setNomM(String nomM) {
		this.nomM = nomM;
	}


	public String getProprietaire() {
		return proprietaire;
	}


	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}


	public String getTypeMonument() {
		return typeMonument;
	}


	public void setTypeMonument(String typeMonument) {
		this.typeMonument = typeMonument;
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


	public Lieu getCodeLieu() {
		return codeLieu;
	}


	public void setCodeLieu(Lieu codeLieu) {
		this.codeLieu = codeLieu;
	}
	
	public List<Celebrite> getCelebrites() {
		return celebrites;
	}


	public void setCelebrites(List<Celebrite> celebrites) {
		this.celebrites = celebrites;
	}




}
