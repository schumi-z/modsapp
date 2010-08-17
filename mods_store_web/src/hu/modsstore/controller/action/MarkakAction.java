package hu.modsstore.controller.action;

import java.util.List;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MarkakAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
		
		System.out.println("Markak Action");
		
		HttpSession session = request.getSession();
		
		TermekService ts = ((TermekService)SpringUtil.getBean("termekService"));
		
		List<Marka> forgalmazottMarkak = ts.listMarka();
		
		List<Meret> meretek =  ts.listMeret();
		
		session.setAttribute("markak", forgalmazottMarkak);
		
		session.setAttribute("meretek", meretek);
		
		return mapping.findForward("success");
		
		}catch (Exception e) {
			request.setAttribute("message", "Hiba a m�rk�k  bet�lt�sekor ");
			return mapping.findForward("errorshop");
		}
	}

}
