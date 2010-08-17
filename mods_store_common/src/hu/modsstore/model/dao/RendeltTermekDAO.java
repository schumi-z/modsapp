package hu.modsstore.model.dao;

import java.util.List;

import hu.modsstore.model.dto.Rendeles;
import hu.modsstore.model.dto.RendeltTermek;

public interface RendeltTermekDAO extends GenericDAO<RendeltTermek, Long> {
	
	List<RendeltTermek> list(Rendeles rendeles);
	
	void deleteForRendeles(Rendeles rendeles);

}
