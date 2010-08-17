package hu.modsstore.model.dao;

import java.util.List;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;

public interface TermekDAO extends GenericDAO<Termek, Long> {
	
	List<Termek> list(Tipus tipus, Marka marka, int firstResult, int maxResults);
	List<Termek> list(Marka marka, int firstIndex, int maxResults);
	long getNumberOfItems(Tipus tipus, Marka marka);
	
	List<Termek> list(Tipus tipus, int firstIndex, int maxResults);
	List<Termek> list(int firstIndex, int maxResults);
	
	Long getCount(Tipus tipus, Marka marka);
	Long getCount(Marka marka);
	Long getCount(Tipus tipus);
	Long getCount();
	List<Termek> listT(Tipus tipus, Marka marka, int firstResult, int maxResults);
	Termek findTermekByTermekKod(String termekkod);
	List<Termek> getLatestTermek(int numberOfItem);

}
