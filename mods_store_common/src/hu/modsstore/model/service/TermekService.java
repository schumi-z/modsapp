package hu.modsstore.model.service;

import java.util.List;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;

public interface TermekService {

	Meret create(Meret meret);	
	Marka create(Marka marka);
	Tipus create(Tipus tipus);
	Termek create(Termek termek);
	Raktar create(Raktar raktar);
	
	Termek update(Termek termek);
	Raktar update(Raktar raktar);
	Tipus update(Tipus tipus);
	Marka update(Marka marka);

	void delete(Meret meret);	
	void delete(Marka marka);
	void delete (Tipus tipus);
	void delete(Termek termek);
	void delete (Raktar raktar);
	
	Meret findMeret(String meret);
	Meret findMeret(Long id);
	Marka findMarka(String nev);
	Marka findMarka(Long id);
	Tipus findTipus(String nev);
	Tipus findTipus(Long id);
	Termek find(Long id);
	Raktar findRaktar(Long id);
	
	List<Meret> listMeret();
	List<Marka> listMarka();
	List<Tipus> listTipus();
	List<Tipus> listTipus(Long markaId);
	List<Termek> list();
	List<Termek> list(Tipus tipus, Marka marka, int firstIndex, int maxResults);
	List<Termek> list(Marka marka, int firstIndex, int maxResults);
	List<Termek> list(Tipus tipus, int firstIndex, int maxResults);
	List<Termek> list(int firstIndex, int maxResults);
	List<Raktar> listRaktar();
	List<Raktar> listRaktar(Termek termek);
	List<Raktar> listRaktar(Termek termek, Meret meret);
	long getNumberOftems(Tipus tipus, Marka marka);
	
	Long getTermekCount(Tipus tipus, Marka marka);
	Long getTermekCount(Marka marka);
	Long getTermekCount(Tipus tipus);
	Long getTermekCount();
	
	List<Raktar> listRaktar(Tipus tipus, Marka marka, int firstIndex, int maxResults);
	List<Raktar> listRaktar(Marka marka, int firstIndex, int maxResults);
	List<Raktar> listRaktar(Tipus tipus, int firstIndex, int maxResults);
	List<Raktar> listRaktar(int firstIndex, int maxResults);
	
	Long getRaktarCount(Tipus tipus, Marka marka);
	Long getRaktarCount(Marka marka);
	Long getRaktarCount(Tipus tipus);
	Long getRaktarCount();
	List<Termek> listT(Tipus tipus, Marka marka, int firstIndex, int maxResults);
	Termek findTermekByTermekKod(String termekkod);
	
	List<Termek> getLatestTermek(int numberOfItem);

	
}
