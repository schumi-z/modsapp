package hu.modsstore.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FELHASZNALOK")
public class Felhasznalo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String felhasznaloNev;

	private String jelszo;
	
	private String so;

	private String telefonszam;

	private String iranyitoszam;

	private String varos;

	private String utca;

	private String hazszam;

	private String emelet;

	private String ajto;

	private String email;

	private String kartyaszam;

	private Szerepkor szerepkor;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "felhasznalo_nev", nullable = false, unique = true, length = 16)
	public String getFelhasznaloNev() {
		return felhasznaloNev;
	}

	public void setFelhasznaloNev(String felhasznaloNev) {
		this.felhasznaloNev = felhasznaloNev;
	}

	@Column(name = "jelszo", nullable = false, length = 128)
	public String getJelszo() {
		return jelszo;
	}

	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}
	
	@Column(name = "so", nullable = false, length = 128)
	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	@Column(name = "telefonszam", length = 16)
	public String getTelefonszam() {
		return telefonszam;
	}

	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}

	@Column(name = "iranyitoszam", length = 8)
	public String getIranyitoszam() {
		return iranyitoszam;
	}

	public void setIranyitoszam(String iranyitoszam) {
		this.iranyitoszam = iranyitoszam;
	}

	@Column(name = "varos", length = 32)
	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	@Column(name = "utca", length = 32)
	public String getUtca() {
		return utca;
	}

	public void setUtca(String utca) {
		this.utca = utca;
	}

	@Column(name = "hazszam", length = 8)
	public String getHazszam() {
		return hazszam;
	}

	public void setHazszam(String hazszam) {
		this.hazszam = hazszam;
	}

	@Column(name = "emelet", length = 16)
	public String getEmelet() {
		return emelet;
	}

	public void setEmelet(String emelet) {
		this.emelet = emelet;
	}

	@Column(name = "ajto", length = 16)
	public String getAjto() {
		return ajto;
	}

	public void setAjto(String ajto) {
		this.ajto = ajto;
	}

	@Column(name = "email", length = 32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "kartyaszam", length = 16)
	public String getKartyaszam() {
		return kartyaszam;
	}

	public void setKartyaszam(String kartyaszam) {
		this.kartyaszam = kartyaszam;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "szerepkor_id", referencedColumnName = "id")
	public Szerepkor getSzerepkor() {
		return szerepkor;
	}

	public void setSzerepkor(Szerepkor szerepkor) {
		this.szerepkor = szerepkor;
	}

}
