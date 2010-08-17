package hu.modsstore.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPUSOK")
public class Tipus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nev;

	private String aktivKepUrl;

	private String inaktivKepUrl;

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

	@Column(name = "aktiv_kep_url", length= 128)
	public String getAktivKepUrl() {
		return aktivKepUrl;
	}

	public void setAktivKepUrl(String aktivKepUrl) {
		this.aktivKepUrl = aktivKepUrl;
	}
	
	@Column(name = "inaktiv_kep_url", length= 128)
	public String getInaktivKepUrl() {
		return inaktivKepUrl;
	}

	public void setInaktivKepUrl(String inaktivKepUrl) {
		this.inaktivKepUrl = inaktivKepUrl;
	}

}
