package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.SzamlaloDAO;
import hu.modsstore.model.dto.Szamlalo;

public class SzamlaloDAOImpl extends
AbstractGenericDAOImpl<Szamlalo, Long> implements SzamlaloDAO  {

	@Override
	protected Class<Szamlalo> getPersistentClass() {
		return Szamlalo.class;
	}

}
