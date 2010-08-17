package hu.modsstore.controller.action;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;

import hu.modsstore.controller.actionform.TermekActionForm;
import hu.modsstore.model.dto.Marka;
import hu.modsstore.model.dto.Termek;
import hu.modsstore.model.dto.Tipus;
import hu.modsstore.model.service.TermekService;
import hu.modsstore.util.SpringUtil;
import hu.modsstore.utility.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UjTermekAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		TermekActionForm f = (TermekActionForm) form;
		
		Termek termek = new Termek();
		termek.setNev(StringUtil.replace(f.getNev()));
		termek.setLeiras(StringUtil.replace(f.getLeiras()));
		termek.setEgysegar(f.getEgysegar());
		termek.setTermekkod(f.getTermekkod());
		termek.setFeltoltesIdopontja(new Timestamp(System.currentTimeMillis()));
		
		termek.setAktiv(f.getAktiv());
		if (termek.getAktiv() == null) {
			termek.setAktiv(false);
		}
		
		Tipus tipus = ((TermekService)SpringUtil.getBean("termekService")).findTipus(f.getTipus());
		Marka marka = ((TermekService)SpringUtil.getBean("termekService")).findMarka(f.getMarka());
		
		if (tipus == null) {
			request.setAttribute("message", "A termék típusa nem létezik.");
			return mapping.findForward("error");
		}
		if (marka == null) {
			request.setAttribute("message", "A termék márkája nem létezik.");
			return mapping.findForward("error");
		}
		
		termek.setTipus(tipus);
		termek.setMarka(marka);
		
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
		
		try {
			((TermekService)SpringUtil.getBean("termekService")).create(termek);
		} catch (Exception e) {
			request.setAttribute("message", "Már létezik ilyen nevű termék. " + e.getMessage());
			return mapping.findForward("error");
		}
		
		return mapping.findForward("success");
	}

}
