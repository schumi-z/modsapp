package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UjMeretActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String meret;
	
	public UjMeretActionForm() {
		super();
	}

	public String getMeret() {
		return meret;
	}

	public void setMeret(String meret) {
		this.meret = meret;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest requenst) {
		ActionErrors errors = super.validate(mapping, requenst);
		
		if (this.meret == null || this.meret.length() == 0) {
			errors.add("meret", new ActionMessage("meret.meret"));
		}
		
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		meret = "";
	}

}
