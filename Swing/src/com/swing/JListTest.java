package com.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListTest extends JFrame {
	
	private static final long serialVersionUID = 2179698719705449096L;

	private JList<String> list = null;
	
	private JScrollPane  scrollPane = null;
	
	public JListTest() {
		this.setSize(new Dimension(300, 300));
		DefaultListModel<String> defalultListModel = new DefaultListModel<>();
		defalultListModel.addElement("hello");
		defalultListModel.addElement("is");
		defalultListModel.addElement("me");
		//list = new JList<>(new JListModel());
		list = new JList<>(defalultListModel);
		list.setVisibleRowCount(3);//用四行来显示
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);//水平显示
		//list.setAutoscrolls(true);
		list.setPrototypeCellValue("www");
		list.setFixedCellWidth(30);//设置单元格的大小
		list.setFixedCellHeight(30);
		
		list.setBorder(BorderFactory.createTitledBorder("JList"));
		list.setBorder(BorderFactory.createEtchedBorder());
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setCellRenderer(new MyLabel());
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			}
		});
		scrollPane = new JScrollPane(list);
		
		this.add(scrollPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JListTest();
				
				
			}
		});
		
		
	}
	
	
	private class MyLabel extends JLabel implements ListCellRenderer<String> {

		private static final long serialVersionUID = -1545450796739415306L;
		
		private Color background;
		private Color foreground;
		private String text;
		
		/**
		 * 
		 * @param list JList
		 * @param value JList 放的值
		 * @param index JList 数据模型中的数据的下标
		 * @param isSelected 当前行是否被选择
		 * @param cellHasFocus 当前行是否被聚焦
		 * @return
		 */
		@Override
		public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
				boolean isSelected, boolean cellHasFocus) {
			
			background = isSelected ? list.getSelectionBackground(): list.getBackground();
			foreground = cellHasFocus ? list.getSelectionForeground() : list.getForeground();
			text = value;
			return this;
		}

		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(background);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			FontMetrics fontMetrics = g.getFontMetrics();
			g.setColor(foreground);
			g.drawString(text, 0, fontMetrics.getAscent());
		}
		
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(30, 30);
		}
		
		
		
	}
	
	@SuppressWarnings("all")
	//定义JList数据模型
	private class JListModel extends AbstractListModel<String> {
		
		private static final long serialVersionUID = -982882130839263691L;
		String s = "abcdefghijklmnopqrstuvwxyz";

		@Override
		public int getSize() {
			//返回该元素个数
			// TODO Auto-generated method stub
			return 26;
		}

		@Override
		public String getElementAt(int index) {
			//返回该模型中给定位置的一个元素
			// TODO Auto-generated method stub
			return String.valueOf(s.charAt(index));
			
		}
		
		
		
	}
	

}
