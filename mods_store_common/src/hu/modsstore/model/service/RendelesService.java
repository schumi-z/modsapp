package hu.modsstore.model.service;

import hu.modsstore.model.composite.RendelesReszletei;
import hu.modsstore.model.dto.Rendeles;
import hu.modsstore.model.dto.RendeltTermek;

import java.util.List;

public interface RendelesService {
	
	List<RendeltTermek> rendel(List<RendeltTermek> elemek);
	
	List<RendelesReszletei> list(Integer statusz, Integer firstIndex, Integer maxResults);

	Rendeles teljesit(Long rendelesId);

	Rendeles create(Rendeles rendeles);
	
	Long getCount(Integer statusz);
	
	void delete(Long rendelesId);

}
