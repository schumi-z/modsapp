package hu.modsstore.model.service.impl;

import hu.modsstore.model.dao.MarkaDAO;
import hu.modsstore.model.dao.MeretDAO;
import hu.modsstore.model.dao.RaktarDAO;
import hu.modsstore.model.dao.TermekDAO;
import hu.modsstore.model.dao.TipusDAO;
import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;

import java.util.List;

public class TermekServiceImpl implements TermekService {

	private MarkaDAO markaDAO;

	private MeretDAO meretDAO;

	private RaktarDAO raktarDAO;

	private TermekDAO termekDAO;

	private TipusDAO tipusDAO;

	public MarkaDAO getMarkaDAO() {
		return markaDAO;
	}

	public void setMarkaDAO(MarkaDAO markaDAO) {
		this.markaDAO = markaDAO;
	}

	public MeretDAO getMeretDAO() {
		return meretDAO;
	}

	public void setMeretDAO(MeretDAO meretDAO) {
		this.meretDAO = meretDAO;
	}

	public RaktarDAO getRaktarDAO() {
		return raktarDAO;
	}

	public void setRaktarDAO(RaktarDAO raktarDAO) {
		this.raktarDAO = raktarDAO;
	}

	public TermekDAO getTermekDAO() {
		return termekDAO;
	}

	public void setTermekDAO(TermekDAO termekDAO) {
		this.termekDAO = termekDAO;
	}

	public TipusDAO getTipusDAO() {
		return tipusDAO;
	}

	public void setTipusDAO(TipusDAO tipusDAO) {
		this.tipusDAO = tipusDAO;
	}
	
	@Override
	public Meret create(Meret meret) {
		return meretDAO.save(meret);
	}
	
	@Override
	public Marka create(Marka marka) {
		return markaDAO.save(marka);
	}
	
	@Override
	public Tipus create(Tipus tipus) {
		return tipusDAO.save(tipus);
	}
	
	@Override
	public Termek create(Termek termek) {
		return termekDAO.save(termek);
	}
	
	@Override
	public Raktar create(Raktar raktar) {
		return raktarDAO.save(raktar);
	}
	
	@Override
	public Termek update(Termek termek) {
		return termekDAO.update(termek);
	}
	
	@Override
	public Raktar update(Raktar raktar) {
		return raktarDAO.update(raktar);
	}
	
	@Override
	public Tipus update(Tipus tipus) {
		return tipusDAO.update(tipus);
	}
	
	@Override
	public Marka update(Marka marka) {
		return markaDAO.update(marka);
	}
	
	@Override
	public void delete(Meret meret) {
		meretDAO.delete(meret);
	}
	
	@Override
	public void delete(Marka marka) {
		markaDAO.delete(marka);
	}
	
	@Override
	public void delete(Tipus tipus) {
		tipusDAO.delete(tipus);
	}
	
	@Override
	public void delete(Termek termek) {
		termekDAO.delete(termek);
	}
	
	@Override
	public void delete(Raktar raktar) {
		raktarDAO.delete(raktar);
	}
	
	@Override
	public Meret findMeret(String meret) {
		return meretDAO.find(meret);
	}
	
	@Override
	public Meret findMeret(Long id) {
		return meretDAO.findById(id);
	}
	
	@Override
	public Marka findMarka(String nev) {
		return markaDAO.find(nev);
	}
	
	@Override
	public Marka findMarka(Long id) {
		return markaDAO.findById(id);
	}
	
	@Override
	public Tipus findTipus(String nev) {
		return tipusDAO.find(nev);
	}
	
	@Override
	public Tipus findTipus(Long id) {
		return tipusDAO.findById(id);
	}
	
	@Override
	public Termek find(Long id) {
		return termekDAO.findById(id);
	}
	
	@Override
	public Raktar findRaktar(Long id) {
		return raktarDAO.findById(id);
	}
	
	@Override
	public List<Meret> listMeret() {
		return meretDAO.listAll();
	}
	
	@Override
	public List<Marka> listMarka() {
		return markaDAO.listAll();
	}
	
	@Override
	public List<Tipus> listTipus() {
		return tipusDAO.listAll();
	}
	
	@Override
	public List<Tipus> listTipus(Long markaId) {
		return tipusDAO.list(markaId);
	}
	
	@Override
	public List<Termek> list() {
		return termekDAO.listAll();
	}
	
	@Override
	public List<Termek> list(Tipus tipus, Marka marka, int firstIndex,
			int maxResults) {
		return termekDAO.list(tipus, marka, firstIndex, maxResults);
	}
	
	@Override
	public List<Termek> listT(Tipus tipus, Marka marka, int firstIndex,
			int maxResults) {
		return termekDAO.listT(tipus, marka, firstIndex, maxResults);
	}
	
	@Override
	public List<Termek> list(Marka marka, int firstIndex, int maxResults) {
		return termekDAO.list(marka, firstIndex, maxResults);
	}
	
	@Override
	public List<Raktar> listRaktar() {
		return raktarDAO.listAll();
	}
	
	@Override
	public List<Raktar> listRaktar(Termek termek) {
		return raktarDAO.list(termek);
	}
	
	@Override
	public List<Raktar> listRaktar(Termek termek, Meret meret) {
		return raktarDAO.list(termek, meret);
	}

	@Override
	public long getNumberOftems(Tipus tipus, Marka marka) {
	
		return termekDAO.getNumberOfItems(tipus, marka);
	}
	
	
	@Override
	public Long getTermekCount(Tipus tipus, Marka marka) {
		return termekDAO.getCount(tipus, marka);
	}
	
	@Override
	public Long getTermekCount(Marka marka) {
		return termekDAO.getCount(marka);
	}
	
	@Override
	public Long getTermekCount(Tipus tipus) {
		return termekDAO.getCount(tipus);
	}
	
	@Override
	public Long getTermekCount() {
		return termekDAO.getCount();
	}
	
	@Override
	public List<Raktar> listRaktar(Tipus tipus, Marka marka, int firstIndex,
			int maxResults) {
		return raktarDAO.list(tipus, marka, firstIndex, maxResults);
	}
	
	@Override
	public List<Raktar> listRaktar(Marka marka, int firstIndex, int maxResults) {
		return raktarDAO.list(marka, firstIndex, maxResults);
	}
	
	@Override
	public List<Raktar> listRaktar(Tipus tipus, int firstIndex, int maxResults) {
		return raktarDAO.list(tipus, firstIndex, maxResults);
	}
	
	@Override
	public List<Raktar> listRaktar(int firstIndex, int maxResults) {
		return raktarDAO.list(firstIndex, maxResults);
	}

	@Override
	public Long getRaktarCount(Tipus tipus, Marka marka) {
		return raktarDAO.getCount(tipus, marka);
	}

	@Override
	public Long getRaktarCount(Marka marka) {
		return raktarDAO.getCount(marka);
	}

	@Override
	public Long getRaktarCount(Tipus tipus) {
		return raktarDAO.getCount(tipus);
	}

	@Override
	public Long getRaktarCount() {
		return raktarDAO.getCount();
	}

	@Override
	public List<Termek> list(Tipus tipus, int firstIndex, int maxResults) {
		return termekDAO.list(tipus, firstIndex, maxResults);
	}
	
	@Override
	public List<Termek> list(int firstIndex, int maxResults) {
		return termekDAO.list(firstIndex, maxResults);
	}

	@Override
	public Termek findTermekByTermekKod(String termekkod) {
		return termekDAO.findTermekByTermekKod(termekkod);
	}

	@Override
	public List<Termek> getLatestTermek(int numberOfItem) {
		return termekDAO.getLatestTermek(numberOfItem);
	}

}
