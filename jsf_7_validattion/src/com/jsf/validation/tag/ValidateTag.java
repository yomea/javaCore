package com.jsf.validation.tag;

import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.servlet.jsp.JspException;

import com.jsf.validation.MyValidation;

public class ValidateTag extends com.sun.faces.taglib.jsf_core.ValidatorTag {
	
	private String pattern;

	private static final long serialVersionUID = -2250001399807908361L;
	
	

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}



	@Override
	protected Validator createValidator() throws JspException {
		
		javax.faces.application.Application application = FacesContext.getCurrentInstance().getApplication();
		
		MyValidation validator = (MyValidation) application.createValidator("com.jsf.entity.pass");
		
		validator.setPattern(pattern);
		
		return validator;
	}

	
	
}
