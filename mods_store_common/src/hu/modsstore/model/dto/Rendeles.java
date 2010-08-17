package hu.modsstore.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RENDELESEK")
public class Rendeles implements Serializable {
	
	public static final int TELJESITETLEN = 0;
	
	public static final int TELJESITETT = 1;
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nev;
	
	private String telefonszam;
	
	private String iranyitoszam;

	private String varos;
	
	private String utca;
	
	private String hazszam;
	
	private String emeletAjto;

	private String email;
	
	private String kartyaszam;
	
	private String fizetesiMod;
	
	private String megjegyzes;
	
	private Integer statusz;
	
	private Timestamp rendelesiIdo;
	
	public Rendeles() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nev", nullable = false, length = 128)
	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	@Column(name = "telefonszam", nullable = false, length = 32)
	public String getTelefonszam() {
		return telefonszam;
	}

	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}

	@Column(name = "iranyitoszam", nullable = false, length = 16)
	public String getIranyitoszam() {
		return iranyitoszam;
	}

	public void setIranyitoszam(String iranyitoszam) {
		this.iranyitoszam = iranyitoszam;
	}

	@Column(name = "varos", nullable = false, length = 128)
	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	@Column(name = "utca", nullable = false, length = 128)
	public String getUtca() {
		return utca;
	}

	public void setUtca(String utca) {
		this.utca = utca;
	}

	@Column(name = "hazszam", nullable = false, length = 16)
	public String getHazszam() {
		return hazszam;
	}

	public void setHazszam(String hazszam) {
		this.hazszam = hazszam;
	}

	@Column(name = "emelet_ajto", nullable = true, length = 32)
	public String getEmeletAjto() {
		return emeletAjto;
	}

	public void setEmeletAjto(String emeletAjto) {
		this.emeletAjto = emeletAjto;
	}

	@Column(name = "email", nullable = false, length = 128)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "kartyaszam", nullable = true, length = 16)
	public String getKartyaszam() {
		return kartyaszam;
	}

	public void setKartyaszam(String kartyaszam) {
		this.kartyaszam = kartyaszam;
	}

	@Column(name = "fizetesi_mod", nullable = false, length = 32)
	public String getFizetesiMod() {
		return fizetesiMod;
	}

	public void setFizetesiMod(String fizetesiMod) {
		this.fizetesiMod = fizetesiMod;
	}

	@Column(name = "megjegyzes", nullable = true, length = 1024)
	public String getMegjegyzes() {
		return megjegyzes;
	}

	public void setMegjegyzes(String megjegyzes) {
		this.megjegyzes = megjegyzes;
	}

	@Column(name = "statusz", nullable = false)
	public Integer getStatusz() {
		return statusz;
	}

	public void setStatusz(Integer statusz) {
		this.statusz = statusz;
	}

	@Column(name = "rendelesi_ido", nullable = false)
	public Timestamp getRendelesiIdo() {
		return rendelesiIdo;
	}

	public void setRendelesiIdo(Timestamp rendelesiIdo) {
		this.rendelesiIdo = rendelesiIdo;
	}

}
