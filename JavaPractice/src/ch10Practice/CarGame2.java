package ch10Practice;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CarGame2 extends JFrame{
	public CarGame2() {
		this.setSize(300,500);
		this.add(new MyPanel3());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		CarGame2 carGame2=new CarGame2();
	}
}
class MyPanel3 extends JPanel implements MouseListener{
	private BufferedImage img=null;
	private int imgX=0, imgY=0;
	
	public MyPanel3() {
		try {
			img=ImageIO.read(new File("car.JFIF"));
		} catch (IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		this.addMouseListener(this);
		this.requestFocus();
		this.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, imgX, imgY, null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		imgX=e.getX();
		imgY=e.getY();
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}