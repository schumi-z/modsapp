package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TorolMeretAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// System.out.println("M�ret t�rl�se: " + request.getParameter("id"));
		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen m\u00e9ret.");
			return mapping.findForward("error");
		}
		Meret meret = service.findMeret(id);
		if (meret == null) {
			request.setAttribute("message", "Nincs ilyen m\u00e9ret.");
			return mapping.findForward("error");
		}
		try {
			service.delete(meret);
		} catch (Exception e) {
			request.setAttribute("message", "Ez a m\u00e9ret nem t\u00f6r\u00f6lhet\u0151, mert l\u00e9tezik ilyen m\u00e9ret\u0171 rakt\u00e1relem.");
			return mapping.findForward("error");
		}
		return mapping.findForward("success");
	}

}
