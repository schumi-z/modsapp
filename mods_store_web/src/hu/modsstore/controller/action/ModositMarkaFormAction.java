package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ModositMarkaFormAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		TermekService service = ((TermekService)SpringUtil.getBean("termekService"));
		Long id = null;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("message", "Nincs ilyen m\u00e1rka.");
			return mapping.findForward("error");
		}
		
		Marka marka = service.findMarka(id);
		if (marka == null) {
			request.setAttribute("message", "Nincs ilyen m\u00e1rka.");
			return mapping.findForward("error");
		}
		
		request.setAttribute("marka", marka);
		
		return mapping.findForward("success");
	}

}
