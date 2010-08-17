package hu.modsstore.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MARKAK")
public class Marka implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nev;

	private String kepUrl;
	
	private String markaIsmerteto;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nev", nullable = false, unique = true, length = 32)
	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	@Column(name = "kep_url", length = 128)
	public String getKepUrl() {
		return kepUrl;
	}

	public void setKepUrl(String kepUrl) {
		this.kepUrl = kepUrl;
	}

	@Column(name = "marka_ismerteto", length = 2147483647, nullable = false)
	public String getMarkaIsmerteto() {
		return markaIsmerteto;
	}

	public void setMarkaIsmerteto(String markaIsmerteto) {
		this.markaIsmerteto = markaIsmerteto;
	}
	
	

}
