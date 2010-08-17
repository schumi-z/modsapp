package hu.modsstore.model.dao.impl;

import java.util.List;

import org.hibernate.Query;

import hu.modsstore.model.dao.RendeltTermekDAO;
import hu.modsstore.model.dto.Rendeles;
import hu.modsstore.model.dto.RendeltTermek;

public class RendeltTermekDAOImpl extends
		AbstractGenericDAOImpl<RendeltTermek, Long> implements RendeltTermekDAO {

	@Override
	protected Class<RendeltTermek> getPersistentClass() {
		return RendeltTermek.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RendeltTermek> list(Rendeles rendeles) {
		Query query = getSession().createQuery(
				"FROM RendeltTermek r WHERE r.rendeles = :rendeles");
			query.setParameter("rendeles", rendeles);
		return query.list();
	}
	
	@Override
	public void deleteForRendeles(Rendeles rendeles) {
		List<RendeltTermek> list = this.list(rendeles);
		for (RendeltTermek rt : list) {
			this.delete(rt);
		}
	}

}
