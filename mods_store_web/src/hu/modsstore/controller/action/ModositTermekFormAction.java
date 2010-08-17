package hu.modsstore.controller.action;

import java.util.List;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ModositTermekFormAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs iylen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		Termek termek = service.find(id);
		if (termek == null) {
			request.setAttribute("message", "Nincs ilyen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		request.setAttribute("termek", termek);
		
		List<Tipus> tipusok = ((TermekService) SpringUtil
				.getBean("termekService")).listTipus();
		List<Marka> markak = ((TermekService) SpringUtil
				.getBean("termekService")).listMarka();

		request.setAttribute("tipusok", tipusok);
		request.setAttribute("markak", markak);
		
		return mapping.findForward("success");
	}

}
