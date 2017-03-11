package com.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class JEditorPaneTest extends JFrame {

	private static final long serialVersionUID = -1346769165188337720L;


	public JEditorPaneTest() throws Exception {
		this.setSize(new Dimension(1300, 700));
		JEditorPane HTML = new JEditorPane("text/html", "请键入URL");
		HTML.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					
					try {
						HTML.setPage(e.getURL());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		});
		HTML.setPage("http://www.baidu.com");
		HTML.setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		JLabel URL_label = new JLabel("URL");
		JTextField field = new JTextField("http://java.sun.com", 20);
		JButton load_button = new JButton("load");
		load_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = field.getText().trim();
				System.out.println(url);
				System.out.println(url.matches("http://[\\w.]+((\\.com)|(\\.cn))"));
				if(url.matches("((http://)|(file://))[\\w.]+((\\.com)|(\\.cn))")) {
					
					try {
						HTML.setPage(url);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		JButton back_button = new JButton("back");
		JCheckBox checkBox = new JCheckBox("Editable");
		checkBox.setHorizontalTextPosition(JCheckBox.LEFT);
		
		panel.add(URL_label);
		panel.add(field);
		panel.add(load_button);
		panel.add(back_button);
		panel.add(checkBox);
		JScrollPane scrollPane = new JScrollPane(HTML);
		this.add(panel, BorderLayout.SOUTH);
		
		this.add(scrollPane);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new JEditorPaneTest();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}
