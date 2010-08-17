package hu.modsstore.controller.action;

import java.util.List;

import hu.modsstore.model.dto.Hirlevel;
import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HirlevelFeliratkozottakAdminAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//System.out.println("#>>>FEliratkozottak");
		
		FelhasznaloService fhsz = (FelhasznaloService) SpringUtil.getBean("felhasznaloService");
	
		List<Hirlevel> feliratkozottak =  fhsz.getSubscribers();
		
		request.setAttribute("feliratkozottak", feliratkozottak);
		
//		for(int i=0; i<feliratkozottak.size(); i++)
//		{
//			System.out.println(feliratkozottak.get(i).getEmailCim());
//		}
//		
//		System.out.println("FEliratkozottak<<<");
		
		return mapping.findForward("success");
	}
}
