package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class TermekActionForm extends AbstractActionForm {

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

	public TermekActionForm() {
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
		
		if (this.nev == null || this.nev.length() == 0) {
			errors.add("nev", new ActionMessage("termek.nev"));
		}
		if (this.egysegar == null || this.egysegar.longValue() <= 0) {
			errors.add("egysegar", new ActionMessage("termek.egysegar"));
		}
		if (this.termekkod == null || this.termekkod.length() == 0) {
			errors.add("termekkod", new ActionMessage("termek.termekkod"));
		}
		if (this.kep == null || this.kep.getFileSize() == 0) {
			errors.add("kep", new ActionMessage("termek.kep"));
		}
		if (this.tipus == null) {
			errors.add("tipus", new ActionMessage("termek.tipus"));
		}
		if (this.marka == null) {
			errors.add("marka", new ActionMessage("termek.marka"));
		}
		
		request.setAttribute("nev", this.nev);
		request.setAttribute("leiras", this.leiras);
		request.setAttribute("egysegar", this.egysegar);
		request.setAttribute("termekkod", this.termekkod);
		request.setAttribute("kep", this.kep);
		request.setAttribute("tipus_id", this.tipus);
		request.setAttribute("marka_id", this.marka);
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		id = null;
		nev = "";
		leiras = "";
		egysegar = null;
		termekkod = "";
		kep = null;
		tipus = null;
		marka = null;
		aktiv = null;
	}

}
