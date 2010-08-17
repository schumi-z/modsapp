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

public class NextAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try{
		
		HttpSession session = request.getSession();

		int actPage = Integer.parseInt(session.getAttribute("actPage")
				.toString());

		int numberOfPages = Integer.parseInt(session.getAttribute(
				"numberOfPages").toString());

		ActionForward aF = new ActionForward();

		if (actPage < numberOfPages) {
			actPage++;
			session.setAttribute("actPage", actPage);

			// System.out.println(request.getRequestURL());

			aF.setPath(session.getAttribute("forwardURL").toString()
					+ "?actPage=" + actPage);

		} else {
			if (numberOfPages != 0) {

				aF.setPath(session.getAttribute("forwardURL").toString()
						+ "?actPage=" + numberOfPages);

			} else {

				aF.setPath(session.getAttribute("forwardURL").toString()
						+ "?actPage=1");

			}
		}

		return aF;
		}catch (Exception e) {
			return mapping.findForward("errorshop");
		}
	}
}
