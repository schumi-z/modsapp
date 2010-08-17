package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Konstans;

public interface KonstansDAO extends GenericDAO<Konstans, Long> {
	
	Konstans find(String kulcs);

}
