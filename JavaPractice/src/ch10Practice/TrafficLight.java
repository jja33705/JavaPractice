package ch10Practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrafficLight extends JFrame{
	public TrafficLight() {
		this.setSize(300, 500);
		this.add(new MyPanel2());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		TrafficLight trafficLight=new TrafficLight();
	}
}

class MyPanel2 extends JPanel implements ActionListener{
	private int lightNumber=0;
	
	public MyPanel2() {
		this.setLayout(new BorderLayout());
		JButton b=new JButton("traggic light turn on");
		b.addActionListener(this);
		this.add(b, BorderLayout.SOUTH);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
		g.drawOval(100, 200, 100, 100);
		g.drawOval(100, 300, 100, 100);
		if(lightNumber==0) {
			g.setColor(Color.RED);
			g.fillOval(100, 100, 100, 100);
		} else if(lightNumber==1) {
			g.setColor(Color.GREEN);
			g.fillOval(100, 200, 100, 100);
		} else {
			g.setColor(Color.YELLOW);
			g.fillOval(100, 300, 100, 100);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(++lightNumber>=3) lightNumber=0;
		repaint();
		
	}
}
