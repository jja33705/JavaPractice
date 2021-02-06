package ch11Practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnowManFace extends JFrame {
	private JButton button;
	private boolean isSmile = true;
	public static void main(String[] args) {
		new SnowManFace();
	}
	
	public SnowManFace() {
		this.setTitle("´«»ç¶÷ ¾ó±¼");
		this.add(new MyPanel(), BorderLayout.CENTER);
		button = new JButton("Ç¥Á¤ º¯°æ");
		button.addActionListener((e)->{
			if(isSmile) {
				isSmile = false;
				repaint();
			} else {
				isSmile = true;
				repaint();
			}
		});
		this.add(button, BorderLayout.SOUTH);
		
		this.setSize(700,730);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.YELLOW);
			g.fillOval(100, 100, 500, 500);
			
			g.setColor(Color.BLACK);
			if(isSmile) {
				g.drawArc(200, 250, 100, 100, 0, 180);
				g.drawArc(400, 250, 100, 100, 0, 180);
				g.drawArc(200, 300, 300, 200, 0, -180);
			} else {
				g.drawLine(200, 275, 300, 275);
				g.drawLine(400, 275, 500, 275);
				g.drawLine(200, 450, 500, 450);
			}
			
			g.setColor(Color.ORANGE);
			g.fillOval(150, 350, 50, 50);
			g.fillOval(500, 350, 50, 50);
		}
	}
}
