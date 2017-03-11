package com.jsf.entity;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.validator.ValidatorException;

@ManagedBean(name="user")
@ApplicationScoped
public class User {

	@ManagedProperty(value="admin")
	private String name;
	@ManagedProperty(value="#{person.password}")
	private String password;
	
	private String outCome = "success";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void validator(FacesContext context, UIComponent component, Object obj) throws ValidatorException {
		String str = (String) obj;
		if(str.length() < 1 || "".equals(str.trim())) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "请不要输入控制OK", "请不要输入控制OK");
			outCome = "failure?faces-redirect=true";
			throw new ValidatorException(message);
		}
		
	}
	
	public void pushValueFromFlash() {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Flash flash = externalContext.getFlash();
		String name = (String) flash.get("name");
		String password = (String) flash.get("password");
		System.out.println(name + "-->" + password);
	}
	
	public String outcome() {
		
		return outCome;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
	
	

}
