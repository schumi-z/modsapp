package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ModositRaktarFormAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen rakt\u00e1relem.");
			return mapping.findForward("error");
		}
		
		Raktar raktar = service.findRaktar(id);
		if (raktar == null) {
			request.setAttribute("message", "Nincs ilyen rakt\u00e1relem.");
			return mapping.findForward("error");
		}
		
		request.setAttribute("raktar", raktar);
		
		/*Termek termek = service.find(raktar.getTermek().getId());
		if (termek == null) {
			request.setAttribute("message", "Nincs ilyen termék.");
			return mapping.findForward("error");
		}*/
		
		request.setAttribute("termek", raktar.getTermek());
		
		return mapping.findForward("success");
	}

}
