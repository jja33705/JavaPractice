package ch12Practice;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	BufferedImage image;
	Capture capture;
	
	public ImagePanel(Capture capture) {
		this.capture = capture;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) return;
		System.out.println(image.getWidth());
		System.out.println(image.getHeight());
		g.drawImage(image, 0, 0, Integer.parseInt(capture.width.getText()), Integer.parseInt(capture.height.getText()), Integer.parseInt(capture.x.getText()), Integer.parseInt(capture.y.getText()), Integer.parseInt(capture.x.getText()) + Integer.parseInt(capture.width.getText()), Integer.parseInt(capture.y.getText()) + Integer.parseInt(capture.height.getText()), null);	
	}
}
