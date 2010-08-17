package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.LoginActionForm;
import hu.modsstore.model.dto.Felhasznalo;
import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AdminLoginAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
		HttpSession session = request.getSession();
		
		LoginActionForm laf = (LoginActionForm) form;
		
		Felhasznalo admin = ((FelhasznaloService)SpringUtil.getBean("felhasznaloService")).find(laf.getFelhasznalonev(), laf.getJelszo());
		
		if (admin!=null)
		{
			session.setAttribute("felhasznalo", admin);
			return mapping.findForward("success");
		}
		else {
			request.setAttribute("userdoesnotexist", "");
			return mapping.findForward("fail");
		}
		
		}catch (Exception e) {
			request.setAttribute("message", "Hiba a bejelentkezéskor");
			return mapping.findForward("error");
		}
		
	}

}
