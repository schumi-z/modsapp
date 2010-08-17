package hu.modsstore.model.dao.impl;

import java.util.List;

import hu.modsstore.model.dao.HirlevelDAO;
import hu.modsstore.model.dto.Hirlevel;

public class HirlevelDAOImpl extends AbstractGenericDAOImpl<Hirlevel, Long> implements HirlevelDAO{

	@Override
	protected Class<Hirlevel> getPersistentClass() {
		return Hirlevel.class;
	}

	@Override
	public boolean feliratkozik(String emailCim) {
		Hirlevel hirlevel = findByEmail(emailCim);
		
		if (hirlevel==null)
		{
			//felir
			hirlevel = new Hirlevel();
			hirlevel.setEmailCim(emailCim);
			getHibernateTemplate().save(hirlevel);
			
			return true;
			
		}else{
			//mar fel van iratkozva uzenet a feluleten
			return false;
		}
	}

	@Override
	public boolean leiratkozik(String emailCim) {
		Hirlevel hirlevel = findByEmail(emailCim);
		
		if (hirlevel!=null)
		{
			//leiratkoztat
			getHibernateTemplate().delete(hirlevel);
			return true;
		}else{
			//nem is volt feliartkozva uzenet a feluleten
			return false;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Hirlevel findByEmail(String email) {
		
		List<Hirlevel> list = getHibernateTemplate().find("FROM Hirlevel h where h.emailCim = ?", email);
		
		return list!=null && !list.isEmpty() ? list.get(0) : null;
	}

}
