package hu.modsstore.controller.action;

import hu.modsstore.webshop.CartItem;
import hu.modsstore.webshop.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TorolKosarbolAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
		
		HttpSession session = request.getSession();
		
		ShoppingCart sc = (ShoppingCart)session.getAttribute("sc");
		
		List<CartItem> carItems = sc.getCart();
		
		String[] selectedItemIds = request.getParameterValues("selected");
		
		for(int i=0; i<selectedItemIds.length; i++)
		{
			for(int j =0; j<carItems.size(); j++)
			{
				if (Long.parseLong(selectedItemIds[i]) == carItems.get(j).getItemID())
				{
					carItems.remove(j);
				}
			}
		}
		
		sc.setCart((ArrayList<CartItem>) carItems);
		
		session.setAttribute("sc", sc);
		
		return mapping.findForward("success");
		
		}catch (Exception e) {
			request.setAttribute("message", "Hiba a t�rl�s sor�n");
			return mapping.findForward("errorshop");
		}
	}

}
