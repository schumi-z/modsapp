package hu.modsstore.utility;

import java.io.Serializable;
import java.util.List;

import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Termek;

public class TermekMerettel extends Termek implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Meret> meretek;

	public List<Meret> getMeretek() {
		return meretek;
	}

	public void setMeretek(List<Meret> meretek) {
		this.meretek = meretek;
	}
	
	
	
	
	

}
