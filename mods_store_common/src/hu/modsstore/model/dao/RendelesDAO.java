package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Rendeles;

import java.util.List;

public interface RendelesDAO extends GenericDAO<Rendeles, Long> {
	
	List<Rendeles> list(Integer statusz, Integer firstIndex, Integer maxResults);
	
	Long getCount(Integer statusz);
	
}
