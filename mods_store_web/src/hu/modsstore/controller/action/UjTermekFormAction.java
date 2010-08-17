package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UjTermekFormAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<Tipus> tipusok = ((TermekService) SpringUtil
				.getBean("termekService")).listTipus();
		List<Marka> markak = ((TermekService) SpringUtil
				.getBean("termekService")).listMarka();

		request.setAttribute("tipusok", tipusok);
		request.setAttribute("markak", markak);
		return mapping.findForward("success");
	}

}
