package com.jackrutorial.model;

import java.util.List;

import javax.persistence.*;



@Entity
public class Departement {

	@Id
	private String dep;
	private String chefLieu;
	private String nomDep;
	private String reg;
	
	//Il existe un unique département ou existe plusieurs lieux 
	@OneToMany(mappedBy="dep", fetch=FetchType.LAZY)
	private List<Lieu> lieux;
	
	



	public Departement() {
	}
	



	public Departement(String dep, String chefLieu, String nomDep, String reg) {
		super();
		this.dep = dep;
		this.chefLieu = chefLieu;
		this.nomDep = nomDep;
		this.reg = reg;
	}




	public String getDep() {
		return dep;
	}


	public void setDep(String dep) {
		this.dep = dep;
	}


	public String getChefLieu() {
		return chefLieu;
	}


	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}


	public String getNomDep() {
		return nomDep;
	}


	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}


	public String getReg() {
		return reg;
	}


	public void setReg(String reg) {
		this.reg = reg;
	}
	
	public List<Lieu> getLieux() {
		return lieux;
	}



	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}


}

