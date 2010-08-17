package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.RendelesLeadasActionForm;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Rendeles;
import hu.modsstore.model.dto.RendeltTermek;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.service.RendelesService;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.Notification;
import hu.modsstore.util.SpringUtil;
import hu.modsstore.webshop.CartItem;
import hu.modsstore.webshop.ShoppingCart;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RendelesLeadasAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
		
//		System.out.println("Rendeles leadasa  Action");
		
		RendelesLeadasActionForm rlaf = (RendelesLeadasActionForm) form;
		
		StringBuffer uzenet = new StringBuffer();
		
		List<CartItem> items = ((ShoppingCart)request.getSession().getAttribute("sc")).getCart();
		
		
		uzenet.append("A következő rendelés érkezett:<br/><br/>");
		for(int i=0; i<items.size(); i++)
		{
			uzenet.append("Termék neve: "+items.get(i).getItemName()+"<br/>"+
					"Termék kód: "+items.get(i).getItemCode()+"<br/>"+
						  "Db szám: "+items.get(i).getCount()+"<br/>"+
						  "Méret: "+items.get(i).getSize()+"<br/>");
			uzenet.append("---------------------------------<br/>");
		}
		
		uzenet.append("<br/><br/>A rendelés értéke: "+((ShoppingCart)request.getSession().getAttribute("sc")).getTotalPrice()+" HUF");
		
		uzenet.append("<br/>Rendelő adatai:<br/><br/>"+
				
						"Név: "+rlaf.getNev()+"<br/>"+
					  "Email: "+rlaf.getEmail()+"<br/>"+
					  "Telefonszám: "+rlaf.getTelszam()+"<br/>"+
					  "Irányítószám: "+rlaf.getIrszam()+"<br/>"+
					  "Város: "+rlaf.getVaros()+"<br/>"+
					  "Utca: "+rlaf.getUtca()+"<br/>"+
					  "Házszám: "+rlaf.getHazszam());
		
		uzenet.append("<br/>--------------------<br/>");
		uzenet.append("Fizetes módja: "+rlaf.getFm()+"<br/>");
		
		if (rlaf.getTk().equals(""))
		{
			uzenet.append("<br/>Törzsvásárlói kártya: nincs");
		}else{
			uzenet.append("<br/>Törzsvásárlói kártya: "+rlaf.getTk());
		}
		
		uzenet.append("<br/>Megjegyzés: "+rlaf.getMegjegyzes());
		
//		System.out.println(uzenet.toString());
		
		Notification email = new Notification();
		email.send("Rendelés érkezett", uzenet.toString());
		
		request.setAttribute("sent", "");
		
		//rendelésk táblába menteni
		
		RendelesService rs = (RendelesService) SpringUtil.getBean("rendelesService");
		
		TermekService ts = (TermekService) SpringUtil.getBean("termekService");
		
		Rendeles rendeles = new Rendeles();
		rendeles.setEmail(rlaf.getEmail());
		rendeles.setEmeletAjto(rlaf.getEmeletajto());
		rendeles.setFizetesiMod(rlaf.getFm());
		rendeles.setHazszam(rlaf.getHazszam());
		rendeles.setIranyitoszam(rlaf.getIrszam());
		rendeles.setKartyaszam(rlaf.getTk());
		rendeles.setMegjegyzes(rlaf.getMegjegyzes());
		rendeles.setNev(rlaf.getNev());
		rendeles.setRendelesiIdo(new Timestamp(System.currentTimeMillis()));
		rendeles.setStatusz(0);
		rendeles.setTelefonszam(rlaf.getTelszam());
		rendeles.setUtca(rlaf.getUtca());
		rendeles.setVaros(rlaf.getVaros());
		
		rendeles = rs.create(rendeles);
		
		
		List<RendeltTermek> elemek = new ArrayList<RendeltTermek>();
		
		Termek termek = null;
		
		Meret meret = null;
		
		for(int i=0; i<items.size(); i++)
		{
			meret = ts.findMeret(items.get(i).getSize());
			System.out.println("TK"+items.get(i).getItemCode());
			termek = ts.findTermekByTermekKod(items.get(i).getItemCode());
			
			RendeltTermek rendeltTermek = new RendeltTermek();
			rendeltTermek.setDarabszam((int)items.get(i).getCount());
			rendeltTermek.setRaktar(ts.listRaktar(termek, meret).get(0));
			rendeltTermek.setRendeles(rendeles);
			
			
			elemek.add(rendeltTermek);
			
		}
		
		rs.rendel(elemek);
		
		email.sendMailToOrder("Sikeres rendelés leadás", "<p>Köszönjük rendelésedet!</p></br> <p>Rendelésedet hamarosan teljesítjük.</p><p>Üdv, MSC</>", rlaf.getEmail());
		
		
		return mapping.findForward("success");
		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Hiba a rendelés leadása során");
			//return mapping.findForward("errorshop");
			return null;
			
		}
	}

}
