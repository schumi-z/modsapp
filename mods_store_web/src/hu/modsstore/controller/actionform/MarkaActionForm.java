package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class MarkaActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nev;
	
	private FormFile kep;
	
	private String ismerteto;
	
	public MarkaActionForm() {
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

	public FormFile getKep() {
		return kep;
	}

	public void setKep(FormFile kep) {
		this.kep = kep;
	}

	public String getIsmerteto() {
		return ismerteto;
	}

	public void setIsmerteto(String ismerteto) {
		this.ismerteto = ismerteto;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		id = null;
		nev = "";
		kep = null;
		ismerteto = "";
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		
		if (this.nev == null || this.nev.length() == 0) {
			errors.add("nev", new ActionMessage("marka.nev"));
		}
		
		if (this.kep == null || this.kep.getFileSize() == 0) {
			errors.add("kep", new ActionMessage("marka.kep"));
		}
		
		if (this.ismerteto == null || this.ismerteto.length() == 0) {
			errors.add("ismerteto", new ActionMessage("marka.ismerteto"));
		}
		
		request.setAttribute("nev", this.nev);
		request.setAttribute("kep", this.kep);
		request.setAttribute("ismerteto", this.ismerteto);
		return errors;
	}

}
