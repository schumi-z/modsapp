package hu.modsstore.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KONSTANSOK")
public class Konstans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String kulcs;
	
	private String ertek;
	
	public Integer intErtek() {
		try {
			return Integer.valueOf(ertek);
		} catch (Exception e) {
			return null;
		}
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

	@Column(name = "kulcs", nullable = false, unique = true, length = 32)
	public String getKulcs() {
		return kulcs;
	}

	public void setKulcs(String kulcs) {
		this.kulcs = kulcs;
	}

	@Column(name = "ertek", nullable = false, unique = false, length = 32)
	public String getErtek() {
		return ertek;
	}

	public void setErtek(String ertek) {
		this.ertek = ertek;
	}

}
