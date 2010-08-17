package hu.modsstore.model.dao;

import java.util.List;

import hu.modsstore.model.dto.Tipus;

public interface TipusDAO extends GenericDAO<Tipus, Long> {
	
	Tipus find(String nev);

	List<Tipus> list(Long markaId);

}
