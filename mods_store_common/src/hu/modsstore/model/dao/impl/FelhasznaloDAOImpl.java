package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.FelhasznaloDAO;
import hu.modsstore.model.dto.Felhasznalo;
import hu.modsstore.util.PasswordService;

import java.util.List;

public class FelhasznaloDAOImpl extends
		AbstractGenericDAOImpl<Felhasznalo, Long> implements FelhasznaloDAO {

	@Override
	protected Class<Felhasznalo> getPersistentClass() {
		return Felhasznalo.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Felhasznalo find(String felhasznalonev, String jelszo) {

		Felhasznalo felh = find(felhasznalonev);

		if (felh == null)
			return null;

		String salt = felh.getSo();
		String encryptedPassword = new PasswordService().encrypt(jelszo, salt);

		List<Felhasznalo> list = getHibernateTemplate()
				.find(
						"FROM Felhasznalo f WHERE f.felhasznaloNev = ? AND f.jelszo = ?",
						new Object[] { felhasznalonev, encryptedPassword });
		return list == null || list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Felhasznalo find(String felhasznalonev) {
		List<Felhasznalo> list = getHibernateTemplate()
				.find("FROM Felhasznalo f WHERE f.felhasznaloNev = ?",
						felhasznalonev);
		return list == null || list.isEmpty() ? null : list.get(0);
	}

}
