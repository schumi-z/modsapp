package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.KonstansDAO;
import hu.modsstore.model.dto.Konstans;

import java.util.List;

public class KonstansDAOImpl extends AbstractGenericDAOImpl<Konstans, Long>
		implements KonstansDAO {

	@Override
	protected Class<Konstans> getPersistentClass() {
		return Konstans.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Konstans find(String kulcs) {
		List<Konstans> list = getHibernateTemplate().find(
				"FROM Konstans k WHERE k.kulcs = ?", kulcs);
		return list == null || list.isEmpty() ? null : list.get(0);
	}

}
