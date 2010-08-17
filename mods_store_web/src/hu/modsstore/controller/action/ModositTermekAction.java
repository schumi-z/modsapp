package hu.modsstore.controller.action;

import hu.modsstore.controller.actionform.ModositTermekActionForm;
import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Termek;
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

public class ModositTermekAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModositTermekActionForm f = (ModositTermekActionForm) form;
		
		Termek termek = ((TermekService)SpringUtil.getBean("termekService")).find(f.getId());
		
		if (f.getNev() != null && !f.getNev().equals("")) {
			termek.setNev(StringUtil.replace(f.getNev()));
		}
		
		if (f.getLeiras() != null && !f.getLeiras().equals("")) {
			termek.setLeiras(StringUtil.replace(f.getLeiras()));
		}
		
		if (f.getEgysegar() != null && f.getEgysegar() > 0) {
			termek.setEgysegar(f.getEgysegar());
		}
		
		if (f.getTermekkod() != null && !f.getTermekkod().equals("")) {
			termek.setTermekkod(f.getTermekkod());
		}
		
		termek.setAktiv(f.getAktiv());
		if (termek.getAktiv() == null) {
			termek.setAktiv(false);
		}
		
		Tipus tipus = ((TermekService)SpringUtil.getBean("termekService")).findTipus(f.getTipus());
		Marka marka = ((TermekService)SpringUtil.getBean("termekService")).findMarka(f.getMarka());
		
		if (tipus == null) {
			request.setAttribute("message", "A termek tipusa nem letezik.");
			return mapping.findForward("error");
		}
		if (marka == null) {
			request.setAttribute("message", "A termek markaja nem letezik.");
			return mapping.findForward("error");
		}
		
		termek.setTipus(tipus);
		termek.setMarka(marka);
		
		if (f.getKep() != null && f.getKep().getFileSize() > 0) {
			FormFile myFile = f.getKep();
			String fileName = myFile.getFileName();
			byte[] fileData = myFile.getFileData();
			
			String fullPath = getServlet().getServletContext().getRealPath(
					"/");
			
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(fullPath + File.separator + "images" +
						File.separator + StringUtil.removeAcutes(StringUtil.replaceBack(marka.getNev())).replaceAll(" ", "_") + File.separator + fileName);
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
	
			termek.setKepUrl(StringUtil.removeAcutes(StringUtil.replaceBack(marka.getNev())).replaceAll(" ", "_") + "/" + fileName);
		}
		
		try {
			((TermekService)SpringUtil.getBean("termekService")).update(termek);
		} catch (Exception e) {e.printStackTrace();
			request.setAttribute("message", "Mar letezik ilyen nevu termek.");
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
