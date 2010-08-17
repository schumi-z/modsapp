package hu.modsstore.controller.action;

import hu.modsstore.model.service.KonstansService;
import hu.modsstore.util.SpringUtil;
import hu.modsstore.utility.Konstansok;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AktualisAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String currentPageString = request.getParameter("page");
		int currentPage = 0;
		try {
			if (currentPageString != null) {
				currentPage = Integer.valueOf(currentPageString);
			}
		}catch (Exception e) {
		}
		
		KonstansService s = (KonstansService)SpringUtil.getBean("konstansService");
		int lastIndex = s.find(Konstansok.LAST_AKTUALIS_INDEX).intErtek();
		int pageCount = s.find(Konstansok.AKTUALIS_PAGE_COUNT).intErtek();
		
		int firstPage = 0;
		int lastPage = (lastIndex + 1) / pageCount;
		if ((lastIndex + 1) % pageCount > 0) {
			++lastPage;
		}
		--lastPage;
		
		if (currentPage < firstPage || currentPage > lastPage) {
			currentPage = 0;
		}
		
		int prevPage = currentPage - 1;
		if (prevPage < 0) {
			prevPage = 0;
		}
		
		int nextPage = currentPage + 1;
		if (nextPage > lastPage) {
			nextPage = lastPage;
		}
		
		int lastItemIndex = lastIndex - currentPage * pageCount;
		int firstItemIndex = lastItemIndex - pageCount + 1;
		if (firstItemIndex < 0) {
			firstItemIndex = 0;
		}
		
		request.setAttribute("firstIndex", "" + firstItemIndex);
		request.setAttribute("lastIndex", "" + lastItemIndex);
		
		request.setAttribute("firstPage", "" + firstPage);
		request.setAttribute("prevPage", "" + prevPage);
		request.setAttribute("nextPage", "" + nextPage);
		request.setAttribute("lastPage", "" + lastPage);
		
		request.setAttribute("page", currentPage);
		
		return mapping.findForward("success");
	}

}
