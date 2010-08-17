package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Felhasznalo;

public interface FelhasznaloDAO extends GenericDAO<Felhasznalo, Long> {
	
	Felhasznalo find(String felhasznalonev, String jelszo);
	Felhasznalo find(String felhasznalonev);

}
