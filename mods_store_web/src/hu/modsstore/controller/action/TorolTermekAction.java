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

public class TorolTermekAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("Term�k t�rl�se: " + request.getParameter("id"));
		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		Termek termek = service.find(id);
		if (termek == null) {
			request.setAttribute("message", "Nincs ilyen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		try {
			service.delete(termek);
		} catch (Exception e) {
			request.setAttribute("message", "A term\u00e9k nem t\u00f6r\u00f6lhet\u0151, mert l\u00e9tezik hozz\u00e1 rakt\u00e1relem.");
			return mapping.findForward("error");
		}
		return mapping.findForward("success");
	}

}
