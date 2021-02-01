package ch10Practice;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarGame extends JFrame{
	public CarGame() {
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MyPanel());
		this.setVisible(true);
	}
	public static void main(String[] args) {
		CarGame carGame=new CarGame();
	}
}
class MyPanel extends JPanel {
	private BufferedImage img=null;
	private int imgX=100, imgY=100;
	
	public MyPanel() {
		try {
			img=ImageIO.read(new File("car.JFIF"));
		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode=e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_UP:
					imgY-=10;
					break;
				case KeyEvent.VK_DOWN:
					imgY+=10;
					break;
				case KeyEvent.VK_LEFT:
					imgX-=10;
					break;
				case KeyEvent.VK_RIGHT:
					imgX+=10;
					break;
				}
				repaint();
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		this.requestFocus();
		this.setFocusable(true);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, imgX, imgY, null);
	}
}
