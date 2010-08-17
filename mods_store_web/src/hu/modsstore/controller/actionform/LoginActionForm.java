package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class LoginActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String felhasznalonev;

	private String jelszo;

	public LoginActionForm() {
		super();
	}

	public String getFelhasznalonev() {
		return felhasznalonev;
	}

	public void setFelhasznalonev(String felhasznalonev) {
		this.felhasznalonev = felhasznalonev;
	}

	public String getJelszo() {
		return jelszo;
	}

	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}
	
	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		return super.validate(arg0, arg1);
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		felhasznalonev = "";
		jelszo = "";
	}

}
