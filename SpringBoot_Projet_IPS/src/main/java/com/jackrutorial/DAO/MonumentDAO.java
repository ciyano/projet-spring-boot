package com.jackrutorial.DAO;

import javax.transaction.Transactional;
import javax.persistence.*;

import org.springframework.stereotype.Service;

import com.jackrutorial.model.*;

@Transactional
@Service
public class MonumentDAO {
	@PersistenceContext
	private EntityManager entityManager;
	public Monument save(Monument monument) {
		// TODO Auto-generated method stub
			entityManager.persist(monument);
			return monument;
	
	}
}
