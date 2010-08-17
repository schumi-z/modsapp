package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.MarkaActionForm;
import hu.modsstore.model.dto.Marka;
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

public class ModositMarkaAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MarkaActionForm f = (MarkaActionForm) form;
		TermekService service = (TermekService) SpringUtil.getBean("termekService");
		
		Marka marka = service.findMarka(f.getId());
		marka.setNev(StringUtil.replace(f.getNev()));
		
		FormFile myFile = f.getKep();
		String fileName = myFile.getFileName();
		byte[] fileData = myFile.getFileData();
		
		String fullPath = getServlet().getServletContext().getRealPath(
				"/");
		FileOutputStream fos = null;
		try {
			new File(fullPath + File.separator + "images" + File.separator +
					StringUtil.removeAcutes(f.getNev()).replaceAll(" ", "_")).mkdir();
			fos = new FileOutputStream(fullPath + File.separator + "images" +
					File.separator + "markak" + File.separator + fileName);
			fos.write(fileData);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Sikertelen.");
			return mapping.findForward("error");
		} finally {
			try {
				fos.close();
			} catch (Exception e) {

			}
		}
	
		marka.setKepUrl(fileName);
		marka.setMarkaIsmerteto(StringUtil.replace(f.getIsmerteto()));

		try {
			service.update(marka);
		} catch (Exception e) {
			request.setAttribute("message", "A m\u00f3dos\u00edt\u00e1s sikertelen.");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
