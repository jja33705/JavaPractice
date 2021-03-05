package ch11Practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quadric extends JPanel implements ActionListener {
	private double a, b, c;
	private JTextField  fieldA, fieldB, fieldC;
	
	public Quadric() {
		fieldA = new JTextField("1.0", 10);
		fieldB = new JTextField("-5.0", 10);
		fieldC = new JTextField("6.0", 10);
		this.add(fieldA);
		this.add(fieldB);
		this.add(fieldC);
		JButton button = new JButton("DRAW");
		add(button);
		button.addActionListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawLine(0, 200, 400, 200);
		g2.drawLine(200, 0, 200, 400);
		g2.setPaint(Color.RED);
		for(int i = -20; i < 20; i++) {
			int x = i;
			int y = (int)(a * x * x + b * x + c);
			g2.fillOval(200 + x - 2, 200 - (y -2), 4, 4);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		a = Double.parseDouble(fieldA.getText());
		b = Double.parseDouble(fieldB.getText());
		c = Double.parseDouble(fieldC.getText());
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("2차함수 그리기");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Quadric());
		frame.setSize(500, 400);
		frame.setVisible(true);
	}

}
