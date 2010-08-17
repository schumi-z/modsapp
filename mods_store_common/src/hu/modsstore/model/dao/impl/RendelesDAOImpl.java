package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.RendelesDAO;
import hu.modsstore.model.dto.Rendeles;

import java.util.List;

import org.hibernate.Query;

public class RendelesDAOImpl extends AbstractGenericDAOImpl<Rendeles, Long>
		implements RendelesDAO {

	@Override
	protected Class<Rendeles> getPersistentClass() {
		return Rendeles.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rendeles> list(Integer statusz, Integer firstIndex,
			Integer maxResults) {
		Query query = null;
		
		if (statusz != null) {
			query = getSession().createQuery(
				"FROM Rendeles r WHERE r.statusz =:statusz ORDER BY r.rendelesiIdo DESC");
			query.setInteger("statusz", statusz.intValue());
		} else {
			query = getSession().createQuery(
				"FROM Rendeles r ORDER BY r.rendelesiIdo DESC");
		}
		if (firstIndex != null) {
			query.setFirstResult(firstIndex.intValue());
		}
		if (maxResults != null) {
			query.setMaxResults(maxResults.intValue());
		}
		return query.list();
	}
	
	@Override
	public Long getCount(Integer statusz) {
		Query query = null;
		
		if (statusz != null) {
			query = getSession().createQuery(
				"SELECT COUNT(*) FROM Rendeles r WHERE r.statusz =:statusz");
			query.setInteger("statusz", statusz.intValue());
		} else {
			query = getSession().createQuery(
				"SELECT COUNT(*) FROM Rendeles r");
		}
		
		return (Long) query.list().get(0);
	}

}
