package hu.modsstore.model.dao.impl;

import java.util.List;

import hu.modsstore.model.dao.MarkaDAO;
import hu.modsstore.model.dto.Marka;

public class MarkaDAOImpl extends AbstractGenericDAOImpl<Marka, Long> implements MarkaDAO{

	@Override
	protected Class<Marka> getPersistentClass() {
		return Marka.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Marka find(String nev) {
		List<Marka> list = getHibernateTemplate().find(
				"FROM Marka m WHERE m.nev = ?", nev);
		return list == null || list.isEmpty() ? null : list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Marka> listAll() {
		return getHibernateTemplate().find(
				"FROM Marka m ORDER BY m.nev");
	}

}
