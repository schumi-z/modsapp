package hu.modsstore.controller.actionform;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class PagingActionForm extends AbstractActionForm {

	private static final long serialVersionUID = 1L;
	
	private Integer pageIndex;
	
	public PagingActionForm() {
		super();
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
		this.pageIndex = null;
	}

}
