package com.swing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class JFormattedTextFieldTest extends JFrame {
	
	private static final long serialVersionUID = -2705197097454756463L;

	public JFormattedTextFieldTest() {
		
		this.setSize(new Dimension(300, 300));
		
		JFormattedTextField formattedTextField = new JFormattedTextField(NumberFormat.getInstance());
		
		formattedTextField.setColumns(6);
		//设置校验器
		formattedTextField.setInputVerifier(new InputVerifier() {
			
			@Override
			public boolean verify(JComponent input) {
				
				return ((JFormattedTextField)input).isEditValid();
			}
		});
		
		formattedTextField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				//System.out.println("remove");
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = "";
				try {
					text = e.getDocument().getText(0, e.getDocument().getLength());
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				System.out.println(text);
				
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				//System.out.println("changed'");
				
			}
		});
		
		add(formattedTextField);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JFormattedTextFieldTest();
				
			}
		});
		
	}

}
