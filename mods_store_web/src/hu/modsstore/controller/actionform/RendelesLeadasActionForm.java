package hu.modsstore.controller.actionform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RendelesLeadasActionForm extends AbstractActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nev;

	private String telszam;

	private String irszam;

	private String varos;

	private String utca;

	private String hazszam;

	private String emeletajto;

	private String fm;

	private String email;

	private String tk;

	private String megjegyzes;

	public RendelesLeadasActionForm() {
		super();
	}

	public String getIrszam() {
		return irszam;
	}

	public void setIrszam(String irszam) {
		this.irszam = irszam;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getTelszam() {
		return telszam;
	}

	public void setTelszam(String telszam) {
		this.telszam = telszam;
	}

	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	public String getUtca() {
		return utca;
	}

	public void setUtca(String utca) {
		this.utca = utca;
	}

	public String getHazszam() {
		return hazszam;
	}

	public void setHazszam(String hazszam) {
		this.hazszam = hazszam;
	}

	public String getEmeletajto() {
		return emeletajto;
	}

	public void setEmeletajto(String emeletajto) {
		this.emeletajto = emeletajto;
	}

	public String getFm() {
		return fm;
	}

	public void setFm(String fm) {
		this.fm = fm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMegjegyzes() {
		return megjegyzes;
	}

	public void setMegjegyzes(String megjegyzes) {
		this.megjegyzes = megjegyzes;
	}

	public String getTk() {
		return tk;
	}

	public void setTk(String tk) {
		this.tk = tk;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = super.validate(mapping, request);

		if (getNev().equals("")) {
			errors.add("nev", new ActionMessage("rendeles.nev"));
		}

		if (getTelszam().equals("")) {
			errors.add("telszam", new ActionMessage("rendeles.telszam"));
		}

		if (!getTelszam().equals("")) {
			Pattern p = Pattern.compile("\\+\\(\\d{2}\\)\\d{9}");

			Matcher m = p.matcher(getTelszam());

			boolean matchFound = m.matches();

			if (!matchFound) {
				errors.add("telszam", new ActionMessage(
						"rendeles.telszamFormat"));
			}

		}
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

		if (getVaros().equals("")) {
			errors.add("varos", new ActionMessage("rendeles.varos"));
		}
		
		if (getIrszam().equals("")){
			errors.add("irszam", new ActionMessage("rendeles.irszam"));
		}

		if (getUtca().equals("")) {
			errors.add("utca", new ActionMessage("rendeles.utca"));
		}

		if (getHazszam().equals("")) {
			errors.add("hazszam", new ActionMessage("rendeles.hazszam"));
		}

		if (getFm() == null) {
			errors.add("fm", new ActionMessage("rendeles.fm"));
		}
		
		
		request.setAttribute("nev_", getNev());
		request.setAttribute("telszam_", getTelszam());
		request.setAttribute("email_", getEmail());
		request.setAttribute("irszam_", getIrszam());
		request.setAttribute("varos_", getVaros());
		request.setAttribute("utca_", getUtca());
		request.setAttribute("hazszam_", getHazszam());
		request.setAttribute("ajto_", getEmeletajto());
		request.setAttribute("tk_", getTk());
		request.setAttribute("megjegyzes_", getMegjegyzes());
		
		return errors;
	}

}
