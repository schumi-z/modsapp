package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MeretekAdminAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// System.out.println("Meretek Action");

		List<Meret> meretek = ((TermekService) SpringUtil
				.getBean("termekService")).listMeret();

		request.setAttribute("meretek", meretek);

		return mapping.findForward("success");
	}

}
