package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Szerepkor;

public interface SzerepkorDAO extends GenericDAO<Szerepkor, Long> {
	
	Szerepkor find(String nev);

}
