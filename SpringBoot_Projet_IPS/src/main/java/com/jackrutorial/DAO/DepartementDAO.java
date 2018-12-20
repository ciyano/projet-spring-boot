package com.jackrutorial.DAO;





import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jackrutorial.model.Departement;






@Transactional
@Service
public class DepartementDAO {
	@PersistenceContext
	private EntityManager entityManager;






	public Departement save(Departement departement) {
		// TODO Auto-generated method stub
			entityManager.persist(departement);
			return departement;
	
	}


	public List<Departement> findAll(){
		Query req=entityManager.createQuery("select p from departement p");
		return req.getResultList();
	}
	











	


}

