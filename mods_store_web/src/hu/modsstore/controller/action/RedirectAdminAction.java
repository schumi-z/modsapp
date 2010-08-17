package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Felhasznalo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RedirectAdminAction extends Action{

	//ez a defaukt redirecttol kicsit elter az admin kezelesehez
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
		
		if (((Felhasznalo)request.getSession().getAttribute("felhasznalo"))!=null)
		{
			//volt bejelentkezve
		return mapping.findForward("success");
		}
		  //nem volt bejelentkezve 
		return mapping.findForward("fail");
		
		}catch (Exception e) {
			request.setAttribute("message", "Hiba az admin pagre való hivatkozáskor");
			return mapping.findForward("error");
		}
	}
	
}
