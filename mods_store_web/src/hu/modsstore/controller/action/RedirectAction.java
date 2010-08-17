package hu.modsstore.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class RedirectAction extends Action{

	private Logger log = Logger.getLogger(RedirectAction.class);
	
	//ezt ilyen redirectnek használom a struts tiles miatt
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		try{
		
		log.info("Redirecting");	
			
		return mapping.findForward("success");
		
		}catch (Exception e) {
			request.setAttribute("message", "Generic redirect error");
			return mapping.findForward("error");
		}
	}

}
