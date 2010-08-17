package hu.modsstore.model.dao.impl;

import java.util.List;

import org.hibernate.Query;

import hu.modsstore.model.dao.RaktarDAO;
import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;

public class RaktarDAOImpl extends AbstractGenericDAOImpl<Raktar, Long>
		implements RaktarDAO {

	@Override
	protected Class<Raktar> getPersistentClass() {
		return Raktar.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> list(Termek termek) {
		return getHibernateTemplate().find("FROM Raktar r WHERE r.termek = ?",
				termek);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> list(Termek termek, Meret meret) {
		return getHibernateTemplate().find(
				"FROM Raktar r WHERE r.termek = ? AND r.meret = ?",
				new Object[] { termek, meret });
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> listAll() {
		return getHibernateTemplate().find(
				"FROM Raktar r ORDER BY r.termek.nev, r.meret.id");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> list(Tipus tipus, Marka marka, int firstIndex,
			int maxResults) {
		Query query = getSession().createQuery(
				"FROM Raktar r WHERE r.termek.tipus = :tipus AND r.termek.marka = :marka ORDER BY r.termek.nev, r.meret.id");
		query.setParameter("tipus", tipus);
		query.setParameter("marka", marka);
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxResults);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> list(Marka marka, int firstIndex, int maxResults) {
		Query query = getSession().createQuery(
				"FROM Raktar r WHERE r.termek.marka = :marka ORDER BY r.termek.nev, r.meret.id");
		query.setParameter("marka", marka);
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxResults);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> list(Tipus tipus, int firstIndex, int maxResults) {
		Query query = getSession().createQuery(
				"FROM Raktar r WHERE r.termek.tipus = :tipus ORDER BY r.termek.nev, r.meret.id");
		query.setParameter("tipus", tipus);
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxResults);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Raktar> list(int firstIndex, int maxResults) {
		Query query = getSession().createQuery(
				"FROM Raktar r ORDER BY r.termek.nev, r.meret.id");
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxResults);
		
		return query.list();
	}
	
	@Override
	public Long getCount(Tipus tipus, Marka marka) {
		Query query = getSession().createQuery(
				"SELECT COUNT(*) FROM Raktar r WHERE r.termek.tipus = :tipus AND r.termek.marka = :marka");
		query.setParameter("tipus", tipus);
		query.setParameter("marka", marka);
		
		return (Long) query.list().get(0);
	}
	
	@Override
	public Long getCount(Marka marka) {
		Query query = getSession().createQuery(
				"SELECT COUNT(*) FROM Raktar r WHERE r.termek.marka = :marka");
		query.setParameter("marka", marka);
		
		return (Long) query.list().get(0);
	}
	
	@Override
	public Long getCount(Tipus tipus) {
		Query query = getSession().createQuery(
				"SELECT COUNT(*) FROM Raktar r WHERE r.termek.tipus = :tipus");
		query.setParameter("tipus", tipus);
		
		return (Long) query.list().get(0);
	}
	
	@Override
	public Long getCount() {
		Query query = getSession().createQuery(
				"SELECT COUNT(*) FROM Raktar r");
		
		return (Long) query.list().get(0);
	}

}
