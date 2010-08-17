package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MarkaForgalmazottTipusaiAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
		
		HttpSession session = request.getSession();
		
		TermekService ts = ((TermekService)SpringUtil.getBean("termekService"));
		
		long markaId = Long.parseLong(request.getParameter("markaId").toString());
		
		Marka marka = ts.findMarka(markaId);
		
		session.setAttribute("markaIsmerteto", marka.getMarkaIsmerteto());
		
		session.setAttribute("markaId", markaId);
		
		session.setAttribute("markanev", marka.getNev());
		
		List<Tipus> kaphatoTipusok = ts.listTipus(markaId);
		
		request.setAttribute("size", kaphatoTipusok.size());
		
		session.setAttribute("kaphatoTipusok", kaphatoTipusok);
		
		return mapping.findForward("success");
		}catch (Exception e) {
			return mapping.findForward("errorshop");
		}
	}

}
