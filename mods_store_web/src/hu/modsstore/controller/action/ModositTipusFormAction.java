package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ModositTipusFormAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen t\u00edpus.");
			return mapping.findForward("error");
		}
		
		Tipus tipus = service.findTipus(id);
		if (tipus == null) {
			request.setAttribute("message", "Nincs ilyen t\u00edpus.");
			return mapping.findForward("error");
		}
		
		request.setAttribute("tipus", tipus);
		
		return mapping.findForward("success");
	}

}
