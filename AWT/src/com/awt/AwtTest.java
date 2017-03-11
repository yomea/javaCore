package com.awt;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

public class AwtTest extends JFrame {
	
	
	private static final long serialVersionUID = -903328675920483484L;

	public AwtTest() {
		this.setSize(new Dimension(500, 300));
		
		
		
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.setStroke(new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		//x, y, width, height, radWidth, radHeight
		graphics.draw(new RoundRectangle2D.Double(150, 200, 50, 50, 20, 20));
		//x, y, width, height, 根据椭圆圆心的角度开始作画，弧形角度（如果是360那么就变成了圆形）
		//open表示图形不闭合，PIE，CHORD
		Arc2D a = new Arc2D.Double(30, 60, 200, 200, 100, 200, Arc2D.Double.OPEN);
		
		QuadCurve2D q = new QuadCurve2D.Double(100, 100, 260, 260, 200, 200);
		
		graphics.rotate(Math.toRadians(10));
		
		graphics.draw(q);
		
		graphics.draw(a);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new AwtTest();
				
			}
		});
		
	}

}
