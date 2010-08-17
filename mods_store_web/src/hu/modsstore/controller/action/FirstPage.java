package hu.modsstore.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 * 
 * @author Pistar Zoltan
 *
 */

public class FirstPage extends Action{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
		
		HttpSession session = request.getSession();
		
		ActionForward aF = new ActionForward();

		
		session.setAttribute("actPage",1);
		
		
		aF.setPath(session.getAttribute("forwardURL").toString()+"?actPage=1");
		
		
		return aF;
		}catch (Exception e) {
			return mapping.findForward("errorshop");
		}
	}

}
