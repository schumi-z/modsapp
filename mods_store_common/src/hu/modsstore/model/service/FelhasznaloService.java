package hu.modsstore.model.service;

import java.util.List;

import hu.modsstore.model.dto.Felhasznalo;
import hu.modsstore.model.dto.Hirlevel;
import hu.modsstore.model.dto.Szamlalo;
import hu.modsstore.model.dto.Szerepkor;

public interface FelhasznaloService {
	
	Szerepkor create(Szerepkor szerepkor);
	Felhasznalo register(Felhasznalo felhasznalo);
	
	void delete(Szerepkor szerepkor);
	void delete(Felhasznalo felhasznalo);
	
	Felhasznalo update(Felhasznalo felhasznalo);
	
	Felhasznalo find(Long id);
	Felhasznalo find(String felhasznalonev);
	Felhasznalo find(String felhasznalonev, String jelszo);
	Szerepkor findSzerepkor(String nev);
	
	Szamlalo findSzamlalo(Long id);
	Szamlalo create(Szamlalo szamlalo);
	Szamlalo update(Szamlalo szamlalo);
	
	List<Szerepkor> listSzerepkor();
	
	boolean feliratkozik(String emailCim);
	boolean leiratkozik(String emailCim);
	List<Hirlevel> getSubscribers(); 

}
