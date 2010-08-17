package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class ModositTermekActionForm extends AbstractActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nev;

	private String leiras;

	private Long egysegar;

	private String termekkod;

	private FormFile kep;

	private Long tipus;

	private Long marka;
	
	private Boolean aktiv;

	public ModositTermekActionForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getLeiras() {
		return leiras;
	}

	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	public Long getEgysegar() {
		return egysegar;
	}

	public void setEgysegar(Long egysegar) {
		this.egysegar = egysegar;
	}

	public String getTermekkod() {
		return termekkod;
	}

	public void setTermekkod(String termekkod) {
		this.termekkod = termekkod;
	}

	public FormFile getKep() {
		return kep;
	}

	public void setKep(FormFile kep) {
		this.kep = kep;
	}

	public Long getTipus() {
		return tipus;
	}

	public void setTipus(Long tipus) {
		this.tipus = tipus;
	}

	public Long getMarka() {
		return marka;
	}

	public void setMarka(Long marka) {
		this.marka = marka;
	}
	
	public Boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(Boolean aktiv) {
		this.aktiv = aktiv;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		id = null;
		nev = null;
		leiras = null;
		egysegar = null;
		termekkod = null;
		kep = null;
		tipus = null;
		marka = null;
		aktiv = null;
	}

}
