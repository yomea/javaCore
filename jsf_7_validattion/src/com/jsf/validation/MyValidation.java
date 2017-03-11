package com.jsf.validation;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class MyValidation implements Validator {
	
	private String pattern;
	
	

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}



	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String lastName = (String) obj;
		
		if (lastName.length() < 6) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "字符长度小于 6", "字符长度不得小于 6");
			//抛出验证异常，就要显示的异常信息一起抛出
			throw new ValidatorException(message);
		}
		//获取页面中设置的pattern
		pattern = (String) component.getAttributes().get("pattern");
		if (!lastName.matches(pattern)) {
			
			String messageBundle = context.getApplication().getMessageBundle();
			Locale locale = context.getViewRoot().getLocale();
			ResourceBundle rb = ResourceBundle.getBundle(messageBundle, locale);
			String messageq = MessageFormat.format(rb.getString("error_info"), new Object[]{});
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageq, messageq);
			throw new ValidatorException(message);
		}
	}

}
