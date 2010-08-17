package hu.modsstore.controller.actionform;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorActionForm;

public abstract class AbstractActionForm extends ValidatorActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AbstractActionForm() {
		super();
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException ex) {
			
		}
	}
	
	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		try {
			arg1.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException ex) {
			
		}
		return super.validate(arg0, arg1);
	}

}
