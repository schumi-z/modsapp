package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Hirlevel;

public interface HirlevelDAO extends GenericDAO<Hirlevel, Long>{

	public Hirlevel findByEmail(String email);

	public boolean feliratkozik(String emailCim);

	public boolean leiratkozik(String emailCim);
	
}
