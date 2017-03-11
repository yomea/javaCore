package com.swing;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableTest extends JFrame {
	
	private static final long serialVersionUID = -2182157220420049586L;
	
	private JTable table = null;
	private JScrollPane scrollPane = null;

	public JTableTest() {
		
		this.setSize(new Dimension(300, 300));
		table = new JTable(new MyTableModel());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//table.setCellEditor(new DefaultCellEditor(new JTextField()));
		table.setAutoCreateRowSorter(true);
	/*	table.setRowSorter(new DefaultRowSorter<TableModel, >() {
		});*/
		scrollPane = new JScrollPane(table);
		table.setRowHeight(30);
		this.add(scrollPane);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JTableTest();
				
			}
		});
		
	}
	
	private class MyTableModel extends AbstractTableModel {
		
		private static final long serialVersionUID = 476774527095218035L;
		
		String[][] users = {{"youth", "hello"}, {"hong", "world"}};

		@Override
		public int getRowCount() {
			
			return 2;
		}

		@Override
		public int getColumnCount() {

			return 2;
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			return users[rowIndex][columnIndex];
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			
			return String.class;
		}
		
		@Override
		public String getColumnName(int column) {
			
			switch(column) {
			case 0 : 
				return "username";
			case 1 : 
				return "password";
			default:
				return "error";
			
			}
			
		}

		
		
	}

}
