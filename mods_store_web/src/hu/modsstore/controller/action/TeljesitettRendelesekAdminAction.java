package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.PagingActionForm;
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

public class TeljesitettRendelesekAdminAction extends Action {
	
	private static final int PAGE_COUNT = 10;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		PagingActionForm f = (PagingActionForm) form;
		int pageIndex = 0;
		if (f != null && f.getPageIndex() != null) {
			pageIndex = f.getPageIndex();
		}
		request.setAttribute("page", pageIndex);
		
		RendelesService service = ((RendelesService) SpringUtil.getBean("rendelesService"));
		
		List<RendelesReszletei> rr = service.list(Rendeles.TELJESITETT, pageIndex * PAGE_COUNT, PAGE_COUNT);
		request.setAttribute("rendelesek", rr);
		
		Long total = service.getCount(Rendeles.TELJESITETT);
		
		long totalPages = total.longValue() / PAGE_COUNT;
		if (total.longValue() % PAGE_COUNT > 0) {
			++totalPages;
		}
		
		request.setAttribute("total", new Long(totalPages));
		
		return mapping.findForward("success");
	}

}
