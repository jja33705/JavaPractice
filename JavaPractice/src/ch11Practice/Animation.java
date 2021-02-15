package ch11Practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JFrame{
	private BufferedImage img;
	
	public static void main(String[] args) {
		new Animation();
	}
	
	public Animation() {
		try {
			img = ImageIO.read(new File("spaceship.png"));
		} catch (IOException e) {
			System.exit(1);
		}
		
		this.setTitle("Animation");
		this.setBackground(Color.BLACK);
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(new MyPanel());
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel implements ActionListener {
		
		private int imgX = 0;
		private int imgY = 800 - img.getHeight();
		
		public MyPanel() {
			Timer timer = new Timer(20, this);
			timer.start();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(img, imgX, imgY, null);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			++imgX;
			--imgY;
			repaint();
		}
	}
}
