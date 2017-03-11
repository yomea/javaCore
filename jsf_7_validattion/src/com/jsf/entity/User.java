package com.jsf.entity;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.jsf.validation.MyValidation;

public class User {
	
	private String firstName;

	private String lastName;
	
	private MyValidation validation = new MyValidation();
	
	public MyValidation getValidation() {
		return validation;
	}

	public void setValidation(MyValidation validation) {
		this.validation = validation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//校验器也可以直接写个方法
	public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String lastName = (String) obj;
		if (lastName.length() < 6) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "字符长度小于 6", "字符长度不得小于 6");
			throw new ValidatorException(message);
		}
		if (!lastName.matches(".+[0-9]+")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "必须包括字符与数字", "必须是字符加数字所组成");
			throw new ValidatorException(message);
		}
	}
	
}
