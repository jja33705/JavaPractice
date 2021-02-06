package ch11Practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorTest extends JFrame implements ActionListener{
	private JButton button;
	private Color color = new Color(0,0,0);
	
	public static void main(String[] args) {
		new ColorTest();
	}
	
	public ColorTest() {
		this.setTitle("Color Test");
		this.setSize(500,500);
		this.add(new MyPanel(), BorderLayout.CENTER);
		button = new JButton("색상 변경");
		button.addActionListener(this);
		this.add(button, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(color);
			g.fillRect(10, 10, 470, 470);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		color=new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
		repaint();
	}
}
