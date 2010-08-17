package hu.modsstore.controller.action;

import hu.modsstore.model.service.RendelesService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TeljesitAdminAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("error", "Nincs ilyen rendel\u00e9s.");
			return mapping.findForward("fail");
		}
		
		((RendelesService) SpringUtil.getBean("rendelesService")).teljesit(id);
		return mapping.findForward("success");
	}

}
