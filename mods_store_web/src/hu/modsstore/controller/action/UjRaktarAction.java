package hu.modsstore.controller.action;

import java.util.List;

import hu.modsstore.controller.actionform.RaktarActionForm;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UjRaktarAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RaktarActionForm f = (RaktarActionForm) form;
		TermekService service = (TermekService) SpringUtil.getBean("termekService");
		Meret meret = service.findMeret(f.getMeret());
		Termek termek = service.find(f.getId());
		
		if (termek == null) {
			request.setAttribute("message", "Nincs ilyen term\u00e9k.");
			return mapping.findForward("error");
		}
		
		if (meret == null) {
			request.setAttribute("message", "Nincs ilyen m\u00e9ret.");
			return mapping.findForward("error");
		}
		
		/*if (f.getDarabszam() < 0) {
			request.setAttribute("message", "A daradsz�m nem lehet negat�v.");
			return mapping.findForward("error");
		}*/
		
		Raktar raktar = new Raktar();
		raktar.setTermek(termek);
		raktar.setMeret(meret);
		raktar.setDarabszam(f.getDarabszam());
		
		try {
			List<Raktar> list = service.listRaktar(termek, meret);
			if (list != null && !list.isEmpty()) {
				request.setAttribute("message", "Ehhez a term\u00e9khez ebben a m\u00e9retben m\u00e1r l\u00e9tezik rakt\u00e1relem.");
				return mapping.findForward("error");
			}
		} catch (Exception e) {
			request.setAttribute("message", "A l\u00e9trehoz\u00e1s sikertelen.");
			return mapping.findForward("error");
		}
		
		try {
			service.create(raktar);
		} catch (Exception e) {
			request.setAttribute("message", "A l\u00e9trehoz\u00e1s sikertelen.");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
