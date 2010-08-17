package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.RaktarActionForm;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ModositRaktarAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("mm");
		RaktarActionForm f = (RaktarActionForm) form;
		TermekService service = (TermekService) SpringUtil.getBean("termekService");
		
		System.out.println(f.getId());
		Raktar raktar = service.findRaktar(f.getId());
		raktar.setDarabszam(f.getDarabszam());

		try {
			service.update(raktar);
		} catch (Exception e) {
			request.setAttribute("message", "A m\u00f3dos\u00edt\u00e1s sikertelen.");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
