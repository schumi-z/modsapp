package hu.modsstore.controller.action;

import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LeiratkozikAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String email = request.getParameter("email");
		
		FelhasznaloService service = (FelhasznaloService) SpringUtil.getBean("felhasznaloService");
		
		if (service.leiratkozik(email)){
		
		request.setAttribute("leliratkozas_sikeres", "");
		}
		else{
			request.setAttribute("on_mar_leiratkozott", "");
		}
		return mapping.findForward("success");
	}

}
