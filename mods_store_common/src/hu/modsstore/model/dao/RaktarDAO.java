package hu.modsstore.model.dao;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;

import java.util.List;

public interface RaktarDAO extends GenericDAO<Raktar, Long> {
	
	List<Raktar> list(Termek termek);
	List<Raktar> list(Termek termek, Meret meret);
	
	List<Raktar> list(Tipus tipus, Marka marka, int firstIndex, int maxResults);
	List<Raktar> list(Marka marka, int firstIndex, int maxResults);
	List<Raktar> list(Tipus tipus, int firstIndex, int maxResults);
	List<Raktar> list(int firstIndex, int maxResults);
	
	Long getCount(Tipus tipus, Marka marka);
	Long getCount(Marka marka);
	Long getCount(Tipus tipus);
	Long getCount();

}
