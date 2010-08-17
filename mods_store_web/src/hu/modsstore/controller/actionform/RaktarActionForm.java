package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class RaktarActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long meret;
	
	private Long darabszam;
	
	public RaktarActionForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMeret() {
		return meret;
	}

	public void setMeret(Long meret) {
		this.meret = meret;
	}

	public Long getDarabszam() {
		return darabszam;
	}

	public void setDarabszam(Long darabszam) {
		this.darabszam = darabszam;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);
		
		if (this.meret == null || this.meret.longValue() <= 0) {
			errors.add("meret", new ActionMessage("raktar.meret"));
		}
		if (this.darabszam == null || this.darabszam.longValue() < 0) {
			errors.add("darabszam", new ActionMessage("raktar.darabszam"));
		}
		
		request.setAttribute("meret_id", this.meret);
		request.setAttribute("db", this.darabszam);
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		id = null;
		meret = null;
		darabszam = null;
	}

}
