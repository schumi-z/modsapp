package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Meret;

public interface MeretDAO extends GenericDAO<Meret, Long> {
	
	Meret find(String meret);

}
