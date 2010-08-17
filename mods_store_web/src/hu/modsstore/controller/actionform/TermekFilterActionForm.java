package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class TermekFilterActionForm extends AbstractActionForm {

	private static final long serialVersionUID = 1L;
	
	private Long tipus;

	private Long marka;
	
	private Integer pageIndex;

	public TermekFilterActionForm() {
		super();
	}

	public Long getTipus() {
		return tipus;
	}

	public void setTipus(Long tipus) {
		this.tipus = tipus;
	}

	public Long getMarka() {
		return marka;
	}

	public void setMarka(Long marka) {
		this.marka = marka;
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		return super.validate(arg0, arg1);
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.marka = null;
		this.tipus = null;
		this.pageIndex = null;
	}

}
