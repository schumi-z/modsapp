package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.UjMeretActionForm;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UjMeretAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UjMeretActionForm f = (UjMeretActionForm) form;
		Meret meret = new Meret();
		meret.setMeret(f.getMeret());
		
		/*if (meret.getMeret() == null || meret.getMeret().length() == 0) {
			request.setAttribute("message", "A n�v k�telez�.");
			return mapping.findForward("error");
		}*/
		
		try {
			((TermekService)SpringUtil.getBean("termekService")).create(meret);
		} catch (Exception e) {
			request.setAttribute("message", "M\u00e1r l\u00e9tezik ilyen nev\u0171 m\u00e9ret.");
			return mapping.findForward("error");
		}
			
		return mapping.findForward("success");
	}

}
