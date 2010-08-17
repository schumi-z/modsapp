package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UjRaktarFormAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//System.out.println("Uj raktar form action");
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Termek termek = service.find(id);
		if (termek == null) {
			request.setAttribute("message", "Nincs ilyen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		request.setAttribute("termek", termek);
		request.setAttribute("meretek", service.listMeret());
		
		return mapping.findForward("success");
	}

}
