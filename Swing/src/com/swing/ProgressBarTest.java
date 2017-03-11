package com.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class ProgressBarTest extends JFrame {
	
	private static final long serialVersionUID = 2369666943424631621L;

	private JProgressBar progressBar = null;
	

	public ProgressBarTest() {
		this.setSize(new Dimension(400, 300));
		
		progressBar = new JProgressBar(0, 100);
		
		progressBar.setValue(0);
		
		progressBar.setStringPainted(true);//显示百分比进度信息
		
		//progressBar.setString("hello");//用hello显示进度信息
		
		this.add(progressBar,BorderLayout.NORTH);
		
		
		
		MyActivity activity = new MyActivity(0, 100);
		activity.execute();
		/*new Thread(new Runnable() {
			int current = 0;
			int target = 100;
			@Override
			public void run() {
				while(current < target) {
					current += 23;
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//可以不需要，因为progress组件会自动将它编程100
					if(current > target) {
						current = target;
						
					}
					progressBar.setValue(current);
				}
				
			}
		}).start();*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	private class MyActivity extends SwingWorker<Void, Integer> {
		
		private int current;
		
		private int target;
		
		public MyActivity(int current, int target) {
			this.current = current;
			this.target = target;
			
		}

		@Override
		protected Void doInBackground() throws Exception {
			
			while(current < target) {
				current += 23;
				
				Thread.sleep(100);
				//可以不需要，因为progress组件会自动将它编程100
				if(current > target) {
					current = target;
					
				}
				progressBar.setValue(current);
				this.publish(current);
			}
			return null;
		}
		
		
		@Override
		protected void process(List<Integer> chunks) {
			for (Integer integer : chunks) {
//				System.out.println(chunks.get(0));
//				System.out.println(chunks.size());
				System.out.println(integer);
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ProgressBarTest();
				
			}
		});
	}

}
