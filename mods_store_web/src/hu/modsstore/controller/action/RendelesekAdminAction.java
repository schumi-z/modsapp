package hu.modsstore.controller.action;

import hu.modsstore.model.composite.RendelesReszletei;
import hu.modsstore.model.dto.Rendeles;
import hu.modsstore.model.service.RendelesService;
import hu.modsstore.util.SpringUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RendelesekAdminAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		List<RendelesReszletei> rr = ((RendelesService) SpringUtil.getBean("rendelesService"))
			.list(Rendeles.TELJESITETLEN, null, null);
		request.setAttribute("rendelesek", rr);
		return mapping.findForward("success");
	}

}
