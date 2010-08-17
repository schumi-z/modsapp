package hu.modsstore.controller.action;

import java.util.ArrayList;
import java.util.List;

import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Meret;
import hu.modsstore.model.dto.Raktar;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;
import hu.modsstore.utility.TermekMerettel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MarkaKaphatoTermekiAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
			
		HttpSession session = request.getSession();
		
		Long markaId = null;
		
		TermekService ts = ((TermekService)SpringUtil.getBean("termekService"));
		
		Marka kivalsztottMarka = null;
		
		if (request.getParameter("markaId")!=null ){
			markaId = Long.parseLong(request.getParameter("markaId").toString());
		}else{
			markaId = Long.parseLong(session.getAttribute("markaId").toString());
		}
		
		kivalsztottMarka = ts.findMarka(markaId);
		
		Long tipusId = 0l;
		
		if (request.getParameter("tipusId")!=null){
		
		tipusId = Long.parseLong(request.getParameter("tipusId").toString());
		
		session.setAttribute("tipusId", tipusId);
		
		session.setAttribute("actPage", 1);
		
		}
		
		tipusId = Long.parseLong(session.getAttribute("tipusId").toString());
		
		System.out.println("A "+markaId+" id-ju marka termekei");
		
		Tipus kivalasztottTipus = ts.findTipus(tipusId);
		
		int actPage = 1;
		
		if (session.getAttribute("actPage")!=null){
			actPage = Integer.parseInt(session.getAttribute("actPage").toString());
		}else{
		session.setAttribute("actPage", actPage);
		}
		
		List<Termek> kaphatoTermekek = ts.listT(kivalasztottTipus,kivalsztottMarka, 10*actPage-10, 10);
		
		long maxItemCount = ((TermekService)SpringUtil.getBean("termekService")).getNumberOftems(kivalasztottTipus,kivalsztottMarka);

		int numberOfPages;
		
		if (maxItemCount % 10 > 0) {
			numberOfPages = (int) ((maxItemCount / 10) + 1);
		} else {
			numberOfPages = (int) (maxItemCount / 10);
		}
		
		session.setAttribute("numberOfPages", numberOfPages);
		
		session.setAttribute("forwardURL", "/markakaphatotermekei.do");
		
		
		
		
		List<TermekMerettel> kaphatoTermekekMerettel = new ArrayList<TermekMerettel>();
		
		for(int i=0; i<kaphatoTermekek.size(); i++)
		{
			Termek aktualisTermek = kaphatoTermekek.get(i);
			
			List<Raktar> elerhetoRaktarak = ts.listRaktar(aktualisTermek);
			
			TermekMerettel termekMerettel = new TermekMerettel();
			
		    termekMerettel.setEgysegar(aktualisTermek.getEgysegar());
		    termekMerettel.setId(aktualisTermek.getId());
		    termekMerettel.setKepUrl(aktualisTermek.getKepUrl());
		    termekMerettel.setLeiras(aktualisTermek.getLeiras());
		    termekMerettel.setMarka(aktualisTermek.getMarka());
		    termekMerettel.setNev(aktualisTermek.getNev());
		    termekMerettel.setTermekkod(aktualisTermek.getTermekkod());
		    termekMerettel.setTipus(aktualisTermek.getTipus());
		    
		    List<Meret> meretek = new ArrayList<Meret>();
		    
		    for(int j=0; j<elerhetoRaktarak.size(); j++){
		    	meretek.add(elerhetoRaktarak.get(j).getMeret());
		    }
		    
		    termekMerettel.setMeretek(meretek);
		    
		    kaphatoTermekekMerettel.add(termekMerettel);
		    
			
		}
		
			
			
			
		session.setAttribute("termekek", kaphatoTermekekMerettel);
		
		
		return mapping.findForward("success");
		
		}catch (Exception e) {
			request.setAttribute("message", "Hiba a termékek betöltése során");
			e.printStackTrace();
			return mapping.findForward("errorshop");
		}
	}

}
