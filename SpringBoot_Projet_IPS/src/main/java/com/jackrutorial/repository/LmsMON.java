package com.jackrutorial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.jackrutorial.model.*;

@Repository
public interface LmsMON extends CrudRepository<Monument ,String > {

}