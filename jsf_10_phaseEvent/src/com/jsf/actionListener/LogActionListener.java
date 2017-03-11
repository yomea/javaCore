package com.jsf.actionListener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class LogActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		System.out.println("正在处理。。。。");
		
	}

}
