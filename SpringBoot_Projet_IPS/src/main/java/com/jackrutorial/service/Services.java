package com.jackrutorial.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jackrutorial.model.*;


import com.jackrutorial.repository.*;

@Service
public class Services  implements ServiceInter{
	@Autowired
	private LmsRepository LmsRepository;
	@Autowired
	private LmsJparepository LmsJparepository;
	@Autowired
	private LmsDEP lmsdep;
	@Autowired
	private LmsMON lmsMON;
	
	
	public  Collection <Lieu> findAllLieu(){
		List<Lieu> lieux= new ArrayList <Lieu>();
		for (Lieu lieu : LmsRepository.findAll()) {
			lieux.add(lieu);
		}
		return lieux;
	}
	
	
	
	public  Collection <Departement> findAlldep(){
		List<Departement> depart= new ArrayList <Departement>();
		for (Departement dep : lmsdep.findAll()) {
			depart.add(dep);
		}
		return depart;
	}
	
	public  Collection <Monument> findAllMon(){
		List<Monument> Monu= new ArrayList <Monument>();
		for (Monument mon : lmsMON.findAll()) {
			Monu.add(mon);
		}
		return 	Monu;
	}
	
	
	
	
	
	
	
	
	public void delete(String codeInsee) {
	 LmsRepository.deleteById(codeInsee);
	
}

	public void deleteDEP(String dep) {
		 lmsdep.deleteById(dep);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	public void  findAll() {
		// TODO Auto-generated method stub
		LmsRepository.findAll();
	}
	public String findByName(String codeInsee) {
		// TODO Auto-generated method stub
		return com.jackrutorial.repository.LmsJparepository.findByNameLike("%"+codeInsee+"%");
	}
	  @Autowired
	    public void setStudentRepository(LmsRepository studentRepository) {
	        this.LmsRepository = studentRepository;
	    }

	    public Iterable<Lieu> listStudentsBySurname(String codeInsee) {
	        return LmsRepository.findBycodeInsee(codeInsee);
	    }
	/*public Lieu getLieuById(String codeInsee) {
		Lieu lieu = LmsRepository.findById(codeInsee).get();
		return lieu;
	}*/
	    public Lieu findOne(String codeInsee) {
			return LmsJparepository.getOne(codeInsee);
		}
		public void modifierLieu(String codeInsee, Lieu lieu) {
			LmsJparepository.save(lieu);
			
		}



	
}