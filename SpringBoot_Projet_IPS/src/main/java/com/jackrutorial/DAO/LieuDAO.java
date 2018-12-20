package com.jackrutorial.DAO;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import com.jackrutorial.model.Lieu;;

@Transactional
@Service
public class LieuDAO {
	@PersistenceContext
	private EntityManager entityManager;


	
	

	public Lieu save(Lieu lieu) {
		entityManager.persist(lieu);
		return lieu;
	}
	

}
