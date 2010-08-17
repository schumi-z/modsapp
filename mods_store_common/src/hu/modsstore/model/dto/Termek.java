package hu.modsstore.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TERMEKEK")
public class Termek implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nev;
	
	private String leiras;
	
	private Long egysegar;
	
	private String termekkod;
	
	private String kepUrl;
	
	private Tipus tipus;
	
	private Marka marka;
	
	private Boolean aktiv;
	
	private Timestamp feltoltesIdopontja;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nev", length = 128, unique = true)
	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	@Column(name = "leiras", length = 128)
	public String getLeiras() {
		return leiras;
	}

	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	@Column(name = "egysegar")
	public Long getEgysegar() {
		return egysegar;
	}

	public void setEgysegar(Long egysegar) {
		this.egysegar = egysegar;
	}

	@Column(name = "termekkod", length = 32)
	public String getTermekkod() {
		return termekkod;
	}

	public void setTermekkod(String termekkod) {
		this.termekkod = termekkod;
	}

	@Column(name = "kep_url", length = 128)
	public String getKepUrl() {
		return kepUrl;
	}

	public void setKepUrl(String kepUrl) {
		this.kepUrl = kepUrl;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "tipus_id", referencedColumnName = "id")
	public Tipus getTipus() {
		return tipus;
	}

	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "marka_id", referencedColumnName = "id")
	public Marka getMarka() {
		return marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

	@Column(name = "aktiv", nullable = false)
	public Boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(Boolean aktiv) {
		this.aktiv = aktiv;
	}

	@Column(name = "feltoltes_idopontja", nullable = false)
	public Timestamp getFeltoltesIdopontja() {
		return feltoltesIdopontja;
	}

	public void setFeltoltesIdopontja(Timestamp feltoltesIdopontja) {
		this.feltoltesIdopontja = feltoltesIdopontja;
	}
	
	

}
