package hu.modsstore.model.dao.impl;

import java.util.List;

import hu.modsstore.model.dao.SzerepkorDAO;
import hu.modsstore.model.dto.Szerepkor;

public class SzerepkorDAOImpl extends AbstractGenericDAOImpl<Szerepkor, Long> implements
		SzerepkorDAO {

	@Override
	protected Class<Szerepkor> getPersistentClass() {
		return Szerepkor.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Szerepkor find(String nev) {
		List<Szerepkor> list = getHibernateTemplate().find(
				"FROM Szerepkor s WHERE s.nev = ?", nev);
		return list == null || list.isEmpty() ? null : list.get(0);
	}

}
