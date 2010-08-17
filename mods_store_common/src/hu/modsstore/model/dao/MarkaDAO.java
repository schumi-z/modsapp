package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Marka;

public interface MarkaDAO extends GenericDAO<Marka, Long> {
	
	Marka find(String nev);

}
