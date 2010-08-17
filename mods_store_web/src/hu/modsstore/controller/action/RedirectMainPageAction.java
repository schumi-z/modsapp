package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Szamlalo;
import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RedirectMainPageAction extends Action {

	private static final Logger log = Logger.getLogger(RedirectMainPageAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();

		try {

			FelhasznaloService fs = ((FelhasznaloService) SpringUtil
					.getBean("felhasznaloService"));
			
			Szamlalo latogatokSzama = fs.findSzamlalo(new Long(1));

			if (latogatokSzama == null) {
				latogatokSzama = new Szamlalo();
				latogatokSzama.setLatogatokSzama(new Long(1));
				session.setAttribute("latogatokszama", 1);
				fs.create(latogatokSzama);
			} else {

				Long latogatokSzamaUj = latogatokSzama.getLatogatokSzama() + 1;
				session.setAttribute("latogatokszama", latogatokSzamaUj);

				latogatokSzama.setLatogatokSzama(latogatokSzamaUj);
				fs.update(latogatokSzama);

			}
			
			return mapping.findForward("success");

		} catch (Exception e) {
			e.printStackTrace();
//			request.setAttribute("message", "Generic redirect error");
			return mapping.findForward("error");
		}
	}

}
