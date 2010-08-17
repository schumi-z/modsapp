package hu.modsstore.controller.action;

import hu.modsstore.model.service.RendelesService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TorolRendelesAdminAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Long id = null;
		try {
			id = Long.valueOf(request.getParameter("id"));
		} catch (Exception e) {
			
		}
		if (id == null) {
			request.setAttribute("message", "Nincs ilyen rendel\u00e9s.");
			return mapping.findForward("error");
		}
		
		RendelesService s = (RendelesService) SpringUtil.getBean("rendelesService");
		try {
			s.delete(id);
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen rendel\u00e9s.");
			return mapping.findForward("error");
		}
		
		if ("teljesitett".equals(request.getParameter("from"))) {
			return mapping.findForward("success2");
		}
		return mapping.findForward("success1");
	}

}
