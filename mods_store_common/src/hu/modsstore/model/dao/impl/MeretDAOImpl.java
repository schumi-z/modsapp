package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.MeretDAO;
import hu.modsstore.model.dto.Meret;

import java.util.List;

public class MeretDAOImpl extends AbstractGenericDAOImpl<Meret, Long> implements MeretDAO{

	@Override
	protected Class<Meret> getPersistentClass() {
		return Meret.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Meret find(String meret) {
		List<Meret> list = getHibernateTemplate().find(
				"FROM Meret m WHERE m.meret = ?", meret);
		return list == null || list.isEmpty() ? null : list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Meret> listAll() {
		return getHibernateTemplate().find(
				"FROM Meret m ORDER BY m.id");
	}

}
