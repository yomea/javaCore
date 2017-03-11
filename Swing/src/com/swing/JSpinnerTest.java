package com.swing;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class JSpinnerTest extends JFrame {
	
	private static final long serialVersionUID = -3382965221768332820L;


	public JSpinnerTest() {
		this.setSize(new Dimension(300, 300));
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(2, 0, 100, 1));
		
		this.add(spinner);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JSpinnerTest();
				
			}
		});
	}

}
