package ch11Practice;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FillShapes extends JFrame {
	public static void main(String[] args) {
		new FillShapes();
	}
	
	public FillShapes() {
		this.setTitle("Java 2D ¿¬½À");
		this.setSize(600, 130);
		
		this.add(new MyPanel());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	class MyPanel extends JPanel {
		ArrayList<Shape> shapeList = new ArrayList<>();
		
		public MyPanel() {
			shapeList.add(new Rectangle2D.Float(10, 10, 70, 80));
			shapeList.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));
			shapeList.add(new Ellipse2D.Float(210, 10, 70, 80));
			shapeList.add(new Arc2D.Float(310, 10, 70, 80, 60, 220, Arc2D.CHORD));
			shapeList.add(new Arc2D.Float(410, 10, 70, 80, 60, 220, Arc2D.CHORD));
			shapeList.add(new Arc2D.Float(510, 10, 70, 80, 60, 210, Arc2D.PIE));
		}
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setStroke(new BasicStroke(3));
			
			GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0, 70, Color.RED);
			
			g2.setColor(Color.RED);
			g2.fill(shapeList.get(0));
			
			g2.setPaint(gp);
			g2.fill(shapeList.get(1));
			
			g2.setColor(Color.RED);
			g2.fill(shapeList.get(2));
			
			g2.setPaint(gp);
			g2.fill(shapeList.get(3));
			
			g2.setColor(Color.RED);
			g2.fill(shapeList.get(4));
			
			g2.setPaint(gp);
			g2.fill(shapeList.get(5));
		}
	}
}
