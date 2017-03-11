package com.jsf.actionListener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class AccessibleActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		System.out.println("检查你是否有权限做这件事。。。");

	}

}
