package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.TipusDAO;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import java.util.List;

public class TipusDAOImpl extends AbstractGenericDAOImpl<Tipus, Long> implements TipusDAO{

	@Override
	protected Class<Tipus> getPersistentClass() {
		return Tipus.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Tipus find(String nev) {
		List<Tipus> list = getHibernateTemplate().find(
				"FROM Tipus t WHERE t.nev = ?", nev);
		return list == null || list.isEmpty() ? null : list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipus> listAll() {
		return getHibernateTemplate().find(
				"FROM Tipus t ORDER BY t.nev");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tipus> list(Long markaId) {
		return getHibernateTemplate().find(
			"FROM Tipus t " +
			"WHERE (SELECT COUNT(*) FROM Termek termek WHERE termek.marka.id = ? AND termek.tipus = t) > 0 " +
			"ORDER BY t.nev", markaId);
	}
	
	public static void main(String[] args) {
		for (Tipus t : ((TermekService)SpringUtil.getBean("termekService")).listTipus(1L)) {
			System.out.println(t.getId());
		}
	}

}
