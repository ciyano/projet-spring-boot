package com.jackrutorial.service;

import com.jackrutorial.model.*;

public interface ServiceInter {
	Iterable<Lieu> listStudentsBySurname(String surname);
}
