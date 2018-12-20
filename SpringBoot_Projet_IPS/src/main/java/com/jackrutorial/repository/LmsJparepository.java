package com.jackrutorial.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.jackrutorial.model.*;

public interface LmsJparepository extends JpaRepository<Lieu , String> {

  static String findByNameLike(String codeInsee) {
	
	return ("codeInsee");
}
	

}