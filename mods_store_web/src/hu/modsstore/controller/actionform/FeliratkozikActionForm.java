package hu.modsstore.controller.actionform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class FeliratkozikActionForm extends AbstractActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public FeliratkozikActionForm() {
		super();
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = super.validate(mapping, request);

		if (getEmail().equals("")) {
			errors.add("email", new ActionMessage("rendeles.email"));
		}
		if (!getEmail().equals("")) {
			// ellenorizni a formajat

			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

			Matcher m = p.matcher(getEmail());

			boolean matchFound = m.matches();

			if (!matchFound) {
				errors.add("email", new ActionMessage("rendeles.emailFormat"));
			}

		}
	
		request.setAttribute("email_", getEmail());
				
		return errors;
	}
	
	
}
