package hu.modsstore.model.service.impl;

import java.util.List;

import hu.modsstore.model.dao.FelhasznaloDAO;
import hu.modsstore.model.dao.HirlevelDAO;
import hu.modsstore.model.dao.SzamlaloDAO;
import hu.modsstore.model.dao.SzerepkorDAO;
import hu.modsstore.model.dto.Felhasznalo;
import hu.modsstore.model.dto.Hirlevel;
import hu.modsstore.model.dto.Szamlalo;
import hu.modsstore.model.dto.Szerepkor;
import hu.modsstore.model.service.FelhasznaloService;

public class FelhasznaloServiceImpl implements FelhasznaloService {

	private FelhasznaloDAO felhasznaloDAO;

	private SzerepkorDAO szerepkorDAO;

	private SzamlaloDAO szamlaloDAO;

	private HirlevelDAO hirlevelDAO;

	public FelhasznaloDAO getFelhasznaloDAO() {
		return felhasznaloDAO;
	}

	public void setFelhasznaloDAO(FelhasznaloDAO felhasznaloDAO) {
		this.felhasznaloDAO = felhasznaloDAO;
	}

	public SzerepkorDAO getSzerepkorDAO() {
		return szerepkorDAO;
	}

	public void setSzerepkorDAO(SzerepkorDAO szerepkorDAO) {
		this.szerepkorDAO = szerepkorDAO;
	}

	public SzamlaloDAO getSzamlaloDAO() {
		return szamlaloDAO;
	}

	public void setSzamlaloDAO(SzamlaloDAO szamlaloDAO) {
		this.szamlaloDAO = szamlaloDAO;
	}

	public HirlevelDAO getHirlevelDAO() {
		return hirlevelDAO;
	}

	public void setHirlevelDAO(HirlevelDAO hirlevelDAO) {
		this.hirlevelDAO = hirlevelDAO;
	}

	@Override
	public Szerepkor create(Szerepkor szerepkor) {
		return szerepkorDAO.save(szerepkor);
	}

	@Override
	public Felhasznalo register(Felhasznalo felhasznalo) {
		return felhasznaloDAO.save(felhasznalo);
	}

	@Override
	public void delete(Szerepkor szerepkor) {
		szerepkorDAO.delete(szerepkor);
	}

	@Override
	public void delete(Felhasznalo felhasznalo) {
		felhasznaloDAO.delete(felhasznalo);
	}

	@Override
	public Felhasznalo update(Felhasznalo felhasznalo) {
		return felhasznaloDAO.update(felhasznalo);
	}

	@Override
	public Felhasznalo find(Long id) {
		return felhasznaloDAO.findById(id);
	}

	@Override
	public Felhasznalo find(String felhasznalonev) {
		return felhasznaloDAO.find(felhasznalonev);
	}

	@Override
	public Felhasznalo find(String felhasznalonev, String jelszo) {
		return felhasznaloDAO.find(felhasznalonev, jelszo);
	}

	@Override
	public Szerepkor findSzerepkor(String nev) {
		return szerepkorDAO.find(nev);
	}

	@Override
	public List<Szerepkor> listSzerepkor() {
		return szerepkorDAO.listAll();
	}

	@Override
	public Szamlalo findSzamlalo(Long id) {
		return szamlaloDAO.findById(id);
	}

	@Override
	public Szamlalo update(Szamlalo szamlalo) {
		return szamlaloDAO.update(szamlalo);
	}

	@Override
	public Szamlalo create(Szamlalo szamlalo) {
		return szamlaloDAO.save(szamlalo);
	}

	@Override
	public boolean feliratkozik(String emailCim) {
		return hirlevelDAO.feliratkozik(emailCim);
	}

	@Override
	public boolean leiratkozik(String emailCim) {
		return hirlevelDAO.leiratkozik(emailCim);
	}

	@Override
	public List<Hirlevel> getSubscribers() {
		return hirlevelDAO.listAll();
	}

}