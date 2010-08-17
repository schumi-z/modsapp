package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.TermekFilterActionForm;
import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Termek;
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

public class TermekekAdminAction extends Action {
	
	private static final int PAGE_COUNT = 10;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TermekService service = ((TermekService) SpringUtil
				.getBean("termekService"));
		
		List<Tipus> tipusok = service.listTipus();
		List<Marka> markak = service.listMarka();

		request.setAttribute("tipusok", tipusok);
		request.setAttribute("markak", markak);
		
		TermekFilterActionForm f = (TermekFilterActionForm) form;
		
		Marka marka = null;
		Tipus tipus = null;
		int pageIndex = 0;
		if (f != null && f.getMarka() != null && f.getMarka().longValue() > 0) {
			marka = service.findMarka(f.getMarka());
			request.setAttribute("marka", marka);
		}
		if (f != null && f.getTipus() != null && f.getTipus().longValue() > 0) {
			tipus = service.findTipus(f.getTipus());
			request.setAttribute("tipus", tipus);
		}
		if (f != null && f.getPageIndex() != null) {
			pageIndex = f.getPageIndex();
		}
		request.setAttribute("page", pageIndex);
		
		List<Termek> termekek = null;
		Long total = null;
		if (marka != null && tipus != null) {
			termekek = service.list(tipus, marka,
					pageIndex * PAGE_COUNT, PAGE_COUNT);
			total = service.getTermekCount(tipus, marka);
		} else if (marka != null) {
			termekek = service.list(marka,
					pageIndex * PAGE_COUNT, PAGE_COUNT);
			total = service.getTermekCount(marka);
		} else if (tipus != null) {
			termekek = service.list(tipus,
					pageIndex * PAGE_COUNT, PAGE_COUNT);
			total = service.getTermekCount(tipus);
		} else {
			termekek = service.list(
					pageIndex * PAGE_COUNT, PAGE_COUNT);
			total = service.getTermekCount();
		}
		
		long totalPages = total.longValue() / PAGE_COUNT;
		if (total.longValue() % PAGE_COUNT > 0) {
			++totalPages;
		}

		request.setAttribute("termekek", termekek);
		request.setAttribute("total", new Long(totalPages));
		return mapping.findForward("success");
	}

}
