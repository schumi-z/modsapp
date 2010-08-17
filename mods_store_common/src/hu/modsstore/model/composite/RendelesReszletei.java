package hu.modsstore.model.composite;

import java.io.Serializable;
import java.util.List;

import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Rendeles;

public class RendelesReszletei implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Rendeles rendeles;
	
	private List<Raktar> raktarak;
	
	private int osszdarabszam;
	
	public RendelesReszletei() {
		
	}

	public Rendeles getRendeles() {
		return rendeles;
	}

	public void setRendeles(Rendeles rendeles) {
		this.rendeles = rendeles;
	}

	public List<Raktar> getRaktarak() {
		return raktarak;
	}

	public void setRaktarak(List<Raktar> raktarak) {
		this.raktarak = raktarak;
	}

	public int getOsszdarabszam() {
		return osszdarabszam;
	}

	public void setOsszdarabszam(int osszdarabszam) {
		this.osszdarabszam = osszdarabszam;
	}

}
