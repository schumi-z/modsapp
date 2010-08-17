package hu.modsstore.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SZAMLALO")
public class Szamlalo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id;

	Long latogatokSzama;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "latogatok_szama", nullable = false)
	public Long getLatogatokSzama() {
		return latogatokSzama;
	}

	public void setLatogatokSzama(Long latogatokSzama) {
		this.latogatokSzama = latogatokSzama;
	}

}
