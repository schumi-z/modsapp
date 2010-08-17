package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.TermekDAO;
import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;

import java.util.List;

import org.hibernate.Query;

public class TermekDAOImpl extends AbstractGenericDAOImpl<Termek, Long> implements TermekDAO{

	
	public long getNumberOfItems(Tipus tipus, Marka marka) {
		Query query = getSession().createQuery("SELECT COUNT(t.id) FROM Termek t WHERE t.tipus = :tipus AND t.marka = :marka AND t.aktiv=:true ");
		query.setParameter("tipus", tipus);
		query.setParameter("marka", marka);
		query.setParameter("true", true);
		
		return (Long)query.uniqueResult();
	}


	@Override
	protected Class<Termek> getPersistentClass() {
		return Termek.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> listT(Tipus tipus, Marka marka, int firstResult,
			int maxResults) {
		
		Query query = getSession().createQuery(
				"FROM Termek t WHERE t.tipus = :tipus AND t.marka = :marka  AND t.aktiv =:true ORDER BY t.nev");
		query.setParameter("tipus", tipus);
		query.setParameter("marka", marka);
		query.setParameter("true", true);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> list(Tipus tipus, Marka marka, int firstResult,
			int maxResults) {
		
		Query query = getSession().createQuery(
				"FROM Termek t WHERE t.tipus = :tipus AND t.marka = :marka ORDER BY t.nev");
		query.setParameter("tipus", tipus);
		query.setParameter("marka", marka);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> list(Marka marka, int firstResult, int maxResults) {
		Query query = getSession().createQuery(
				"FROM Termek t WHERE t.marka = :marka ORDER BY t.nev");
		query.setParameter("marka", marka);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);

		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> list(Tipus tipus, int firstResult, int maxResults) {
		Query query = getSession().createQuery(
				"FROM Termek t WHERE t.tipus = :tipus ORDER BY t.nev");
		query.setParameter("tipus", tipus);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);

		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> list(int firstResult, int maxResults) {
		Query query = getSession().createQuery(
				"FROM Termek t ORDER BY t.nev");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);

		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> listAll() {
		return getHibernateTemplate().find(
			"FROM Termek t ORDER BY t.nev");
	}
	
	@Override
	public Long getCount(Tipus tipus, Marka marka) {
		Query query = getSession().createQuery(
				"SELECT COUNT(*) FROM Termek t WHERE t.tipus = :tipus AND t.marka = :marka");
		query.setParameter("tipus", tipus);
		query.setParameter("marka", marka);

		return (Long) query.list().get(0);
	}
	
	@Override
	public Long getCount(Marka marka) {
		Query query = getSession().createQuery(
			"SELECT COUNT(*) FROM Termek t WHERE t.marka = :marka");
	query.setParameter("marka", marka);
	
	return (Long) query.list().get(0);
	}
	
	@Override
	public Long getCount(Tipus tipus) {
		Query query = getSession().createQuery(
			"SELECT COUNT(*) FROM Termek t WHERE t.tipus = :tipus");
		query.setParameter("tipus", tipus);

		return (Long) query.list().get(0);
	}
	
	@Override
	public Long getCount() {
		Query query = getSession().createQuery(
			"SELECT COUNT(*) FROM Termek t");

		return (Long) query.list().get(0);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Termek findTermekByTermekKod(String termekkod) {
		
		List<Termek> termekek = getSession().createQuery("FROM Termek t WHERE t.termekkod LIKE :termekkod").setParameter("termekkod", termekkod).list(); 
			
		return termekek.isEmpty() || termekek == null ? null : termekek.get(0);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Termek> getLatestTermek(int numberOfItem) {
		
		List<Termek> latest;
		
		latest = getSession().createQuery("FROM Termek t order by t.feltoltesIdopontja DESC").list();
		
		if (latest.size()>numberOfItem)
		 return latest.subList(0, numberOfItem);
		else
		 return latest;
	}

}
