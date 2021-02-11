package ch11Practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrayScaleImage extends JFrame{
	private BufferedImage img;
	
	public static void main(String[] args) {
		new GrayScaleImage();
	}
	
	public GrayScaleImage() {
		try {
			img = ImageIO.read(new File("Lenna.png"));
		} catch (IOException e) {
			System.exit(1);
		}
		this.add(new MyPanel());
		this.pack();
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	class MyPanel extends JPanel{
		public MyPanel() {
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			for(int i = 0; i < img.getWidth(); i++) {
				for(int j = 0; j < img.getHeight(); j++) {
					Color color = new Color(img.getRGB(i, j));
					int red = color.getRed();
					int green = color.getGreen();
					int blue = color.getBlue();
					int avg = (red + green + blue) /3;
					color = new Color(avg, avg, avg);
					img.setRGB(i, j, color.getRGB());
				}
			}
			g.drawImage(img, 0, 0, null);
		}
		
		@Override
		public Dimension getPreferredSize() {
			if (img == null) {
				return new Dimension(100, 100);
			} else {
				return new Dimension(img.getWidth(), img.getHeight());
			}
			
		}
	}
}
