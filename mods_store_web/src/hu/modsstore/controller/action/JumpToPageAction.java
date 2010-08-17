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

public class JumpToPageAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try{
		
		HttpSession session = request.getSession();

		session.setAttribute("actPage", Integer.parseInt(request.getParameter("actPage")));

		ActionForward aF = new ActionForward();

		aF.setPath(session.getAttribute("forwardURL").toString() + "?actPage="
				+ request.getParameter("actPage"));

		return aF;
		}catch (Exception e) {
			return mapping.findForward("errorshop");
		}
	}

}
