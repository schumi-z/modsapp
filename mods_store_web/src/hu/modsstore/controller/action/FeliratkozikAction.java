package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.FeliratkozikActionForm;
import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class FeliratkozikAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("Feliratkozik Action");
		
		FeliratkozikActionForm feliratkozikForm = (FeliratkozikActionForm) form;
		
		FelhasznaloService service = (FelhasznaloService) SpringUtil.getBean("felhasznaloService");
		
		
		
		if (service.feliratkozik(feliratkozikForm.getEmail()))
		{
			request.setAttribute("feliratkozas_sikeres", "");
		}else{
			
			request.setAttribute("mar_olvasonk", "");
		}
			
		return mapping.findForward("success");	
		
		
		
	}
}
