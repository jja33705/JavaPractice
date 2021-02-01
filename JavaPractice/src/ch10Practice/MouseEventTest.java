package ch10Practice;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest extends JFrame{
	public MouseEventTest() {
		this.setSize(300,300);
		this.setTitle("마우스로 사각형 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MyPanel4());
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MouseEventTest mouseEventTest=new MouseEventTest();
	}
}

class MyPanel4 extends JPanel implements MouseListener{
	ArrayList<Rectangle> list=new ArrayList<>();
	BufferedImage img=null;
	public MyPanel4() {
		this.addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Rectangle r:list) {
			g.drawRect(r.x, r.y, r.w, r.h);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Rectangle rectangle=new Rectangle();
		rectangle.x=e.getX();
		rectangle.y=e.getY();
		rectangle.w=50;
		rectangle.h=50;
		list.add(rectangle);
		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class Rectangle {
	int x, y, w, h;
}
