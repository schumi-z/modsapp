package hu.modsstore.model.service.impl;

import hu.modsstore.model.composite.RendelesReszletei;
import hu.modsstore.model.dao.RendelesDAO;
import hu.modsstore.model.dao.RendeltTermekDAO;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Rendeles;
import hu.modsstore.model.dto.RendeltTermek;
import hu.modsstore.model.service.RendelesService;

import java.util.ArrayList;
import java.util.List;

public class RendelesServiceImpl implements RendelesService {
	
	private RendelesDAO rendelesDAO;
	
	private RendeltTermekDAO rendeltTermekDAO;

	public RendelesDAO getRendelesDAO() {
		return rendelesDAO;
	}

	public void setRendelesDAO(RendelesDAO rendelesDAO) {
		this.rendelesDAO = rendelesDAO;
	}

	public RendeltTermekDAO getRendeltTermekDAO() {
		return rendeltTermekDAO;
	}

	public void setRendeltTermekDAO(RendeltTermekDAO rendeltTermekDAO) {
		this.rendeltTermekDAO = rendeltTermekDAO;
	}

	@Override
	public List<RendelesReszletei> list(Integer statusz, Integer firstIndex,
			Integer maxResults) {
		List<Rendeles> rendelesek = rendelesDAO.list(statusz, firstIndex, maxResults);
		if (rendelesek == null) {
			return null;
		}
		List<RendelesReszletei> result = new ArrayList<RendelesReszletei>();
		for (Rendeles rendeles : rendelesek) {
			List<RendeltTermek> rt = rendeltTermekDAO.list(rendeles);
			RendelesReszletei rr = new RendelesReszletei();
			rr.setRendeles(rendeles);
			List<Raktar> raktarak = new ArrayList<Raktar>();
			int total = 0;
			for (RendeltTermek t : rt) {
				Raktar raktar = new Raktar();
				raktar.setMeret(t.getRaktar().getMeret());
				raktar.setTermek(t.getRaktar().getTermek());
				raktar.setDarabszam((long) t.getDarabszam());
				raktarak.add(raktar);
				total += t.getDarabszam();
			}
			rr.setOsszdarabszam(total);
			rr.setRaktarak(raktarak);
			result.add(rr);
		}
		return result;
	}

	@Override
	public List<RendeltTermek> rendel(List<RendeltTermek> elemek) {
		List<RendeltTermek> rt = new ArrayList<RendeltTermek>();
		for (RendeltTermek raktar : elemek) {
			rt.add(rendeltTermekDAO.save(raktar));
		}
		return rt;  
	}
	
	@Override
	public Rendeles teljesit(Long rendelesId) {
		Rendeles rendeles = rendelesDAO.findById(rendelesId);
		rendeles.setStatusz(Rendeles.TELJESITETT);
		return rendelesDAO.update(rendeles);
	}

	@Override
	public Rendeles create(Rendeles rendeles) {
		return rendelesDAO.save(rendeles);
	}
	
	@Override
	public Long getCount(Integer statusz) {
		return rendelesDAO.getCount(statusz);
	}
	
	@Override
	public void delete(Long rendelesId) {
		Rendeles rendeles = rendelesDAO.findById(rendelesId);
		rendeltTermekDAO.deleteForRendeles(rendeles);
		rendelesDAO.delete(rendeles);
	}

}
