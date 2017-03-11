package com.jsf.actionListener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class ValueChangeListenerTest implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent arg0) throws AbortProcessingException {
		System.out.println(arg0);
		
	}

}
