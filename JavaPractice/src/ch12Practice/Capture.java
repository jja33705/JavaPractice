package ch12Practice;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Capture extends JFrame implements ActionListener {
	private ImagePanel imagePanel;
	JTextField x, y, width, height;
	
	public Capture() {
		this.setTitle("ĸó �׽�Ʈ");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonPanel = new JPanel();
		
		JLabel location = new JLabel("ĸó ��ġ");
		buttonPanel.add(location);
		x = new JTextField(4);
		buttonPanel.add(x);
		y = new JTextField(4);
		buttonPanel.add(y);
		
		JButton captureButton = new JButton("ĸó");
		captureButton.addActionListener(this);
		buttonPanel.add(captureButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		JLabel size = new JLabel("ĸó ũ��");
		buttonPanel.add(size);
		width = new JTextField(4);
		buttonPanel.add(width);
		height = new JTextField(4);
		buttonPanel.add(height);
		
		imagePanel = new ImagePanel(this);
		this.add(imagePanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Capture();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(new Rectangle(Integer.parseInt(width.getText()) + Integer.parseInt(x.getText()), Integer.parseInt(height.getText()) + Integer.parseInt(y.getText())));
			image.flush();
			imagePanel.image = image;
			imagePanel.repaint();
			this.setSize(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
	}
	
}
