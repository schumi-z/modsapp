package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.TipusActionForm;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;
import hu.modsstore.utility.StringUtil;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class ModositTipusAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TipusActionForm f = (TipusActionForm) form;
		TermekService service = (TermekService) SpringUtil.getBean("termekService");
		
		Tipus tipus = service.findTipus(f.getId());
		tipus.setNev(StringUtil.replace(f.getNev()));
		
		FormFile myFile1 = f.getAktivKep();
		String fileName1 = myFile1.getFileName();
		byte[] fileData1 = myFile1.getFileData();
		
		FormFile myFile2 = f.getInaktivKep();
		String fileName2 = myFile2.getFileName();
		byte[] fileData2 = myFile2.getFileData();
		
		String fullPath = getServlet().getServletContext().getRealPath(
				"/");
		FileOutputStream fos1 = null;
		FileOutputStream fos2 = null;
		try {
			fos1 = new FileOutputStream(fullPath + File.separator + 
					"images" + File.separator + "tipusok" + File.separator + fileName1);
			fos2 = new FileOutputStream(fullPath + File.separator + 
					"images" + File.separator + "tipusok" + File.separator + fileName2);
			fos1.write(fileData1);
			fos1.flush();
			fos2.write(fileData2);
			fos2.flush();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Sikertelen.");
			return mapping.findForward("error");
		} finally {
			try {
				fos1.close();
				fos2.close();
			} catch (Exception e) {

			}
		}
	
		tipus.setAktivKepUrl(fileName1);
		tipus.setInaktivKepUrl(fileName2);

		try {
			service.update(tipus);
		} catch (Exception e) {
			request.setAttribute("message", "A m\u00f3dos\u00edt\u00e1s sikertelen.");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
