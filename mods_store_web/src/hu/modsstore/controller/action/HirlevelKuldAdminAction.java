package hu.modsstore.controller.action;

import java.util.List;

import hu.modsstore.controller.actionform.HirlevelKuldAdminActionForm;
import hu.modsstore.model.dto.Hirlevel;
import hu.modsstore.model.service.FelhasznaloService;
import hu.modsstore.util.Notification;
import hu.modsstore.util.SpringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class HirlevelKuldAdminAction extends Action {

	private static final String LEIRATKOZIK_URL = "http://modsstore.hu/leliratkozik.do?email=";
	
	private static final String MSG_FOOTER_START = "Amennyiben le szeretne iratkozni hírlevelünkről azt az alábbi linken teheti meg: <a href=\"";
	
	private static final String MSG_FOOTER_END ="\"> Leiratkozik</a>";
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HirlevelKuldAdminActionForm hkaaf = (HirlevelKuldAdminActionForm) form;
		
		String msg =  hkaaf.getHmessage();
		
		FelhasznaloService service = (FelhasznaloService) SpringUtil.getBean("felhasznaloService");
		
		List<Hirlevel> feliratkozottakListaja = service.getSubscribers();
		
		Notification notification = new Notification();
		
		for (Hirlevel hirlevel : feliratkozottakListaja) {
			 
			 notification.sendToEmailAddress("#ModsStore hirlevel#", msg, msgFooterCreator(hirlevel), hirlevel.getEmailCim());
		}
		
//		System.out.println(msg);
		
		request.setAttribute("hirlevel_kezbesitve", " ");
		
		return mapping.findForward("success");
	}

	private String msgFooterCreator(Hirlevel hirlevel) {
		
		return MSG_FOOTER_START+LEIRATKOZIK_URL+hirlevel.getEmailCim()+MSG_FOOTER_END;
	}
	
}
