package com.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.jsf.entity.User;

public class MyConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		//youth,hong
		String[] name = arg2.split(",");
		User user = new User();
		
		user.setFirstName(name[0]);
		user.setLastName(name[1]);
		return user;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		User user = (User) arg2;
		String str = user.getFirstName() + "\"" + user.getLastName();
		return str;
	}

}
