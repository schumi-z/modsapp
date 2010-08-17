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
@Table(name = "RENDELT_TERMEKEK")
public class RendeltTermek implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Rendeles rendeles;
	
	private Raktar raktar;
	
	private Integer darabszam;
	
	public RendeltTermek() {
		
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "rendeles_id", referencedColumnName = "id")
	public Rendeles getRendeles() {
		return rendeles;
	}

	public void setRendeles(Rendeles rendeles) {
		this.rendeles = rendeles;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "raktar_id", referencedColumnName = "id")
	public Raktar getRaktar() {
		return raktar;
	}

	public void setRaktar(Raktar raktar) {
		this.raktar = raktar;
	}

	@Column(name = "darabszam", nullable = false)
	public Integer getDarabszam() {
		return darabszam;
	}

	public void setDarabszam(Integer darabszam) {
		this.darabszam = darabszam;
	}

}
