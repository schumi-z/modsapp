package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class TipusActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nev;
	
	private FormFile aktivKep;
	
	private FormFile inaktivKep;

	public TipusActionForm() {
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
	
	public FormFile getAktivKep() {
		return aktivKep;
	}

	public void setAktivKep(FormFile aktivKep) {
		this.aktivKep = aktivKep;
	}

	public FormFile getInaktivKep() {
		return inaktivKep;
	}

	public void setInaktivKep(FormFile inaktivKep) {
		this.inaktivKep = inaktivKep;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		
		if (this.nev == null || this.nev.length() == 0) {
			errors.add("nev", new ActionMessage("tipus.nev"));
		}
		if (this.aktivKep == null || this.aktivKep.getFileSize() == 0) {
			errors.add("aktivKep", new ActionMessage("tipus.aktivKep"));
		}
		if (this.inaktivKep == null || this.inaktivKep.getFileSize() == 0) {
			errors.add("inaktivKep", new ActionMessage("tipus.inaktivKep"));
		}
		
		request.setAttribute("nev", this.nev);
		request.setAttribute("aktiv_kep", this.aktivKep);
		request.setAttribute("inaktiv_kep", this.inaktivKep);
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		id = null;
		nev = "";
		aktivKep = null;
		inaktivKep = null;
	}

}