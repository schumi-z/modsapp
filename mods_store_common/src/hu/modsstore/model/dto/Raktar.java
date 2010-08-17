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
@Table(name = "RAKTAR")
public class Raktar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long darabszam;

	private Termek termek;

	private Meret meret;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "darabszam", nullable = false)
	public Long getDarabszam() {
		return darabszam;
	}

	public void setDarabszam(Long darabszam) {
		this.darabszam = darabszam;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "termek_id", referencedColumnName = "id")
	public Termek getTermek() {
		return termek;
	}

	public void setTermek(Termek termek) {
		this.termek = termek;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "meret_id", referencedColumnName = "id")
	public Meret getMeret() {
		return meret;
	}

	public void setMeret(Meret meret) {
		this.meret = meret;
	}

}
