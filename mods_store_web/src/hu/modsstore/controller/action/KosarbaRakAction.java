package hu.modsstore.controller.action;

import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;
import hu.modsstore.webshop.CartItem;
import hu.modsstore.webshop.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class KosarbaRakAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			System.out.println("Kosarba rak Action");

			HttpSession session = request.getSession();

			ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");

			if (sc == null) {
				System.out.println("Cartot kell p�ld�nyos�tani, majd hozzadni");
				sc = new ShoppingCart();

			}

			if (request.getParameter("termekId") != null) {
				
				

				long termekId = Long
						.parseLong(request.getParameter("termekId"));

				TermekService ts = ((TermekService) SpringUtil
						.getBean("termekService"));
				
				Termek hozzaadandoTermek = ts.find(termekId);

				
				
				sc.addItem(new CartItem(new Long(hozzaadandoTermek.getId()+System.currentTimeMillis()),
						hozzaadandoTermek.getNev(), hozzaadandoTermek
								.getEgysegar(), 1,request.getParameter("size"),
								hozzaadandoTermek.getTermekkod()));

			}

			session.setAttribute("sc", sc);

			return mapping.findForward("success");

		} catch (Exception e) {
			request.setAttribute("message", "Hiba a term�k kos�rba pakol�sa sor�n");
			return mapping.findForward("errorshop");
		}
	}

}
