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

public class TorolRaktarAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//System.out.println("Rakt�r t�rl�se: " + request.getParameter("id"));
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
		
		try {
			service.delete(raktar);
		} catch (Exception e) {
			request.setAttribute("message", "A t\u00f6rl\u00e9s sikertelen.");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
