package ch10Practice;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scribble extends JFrame {
	public Scribble() {
		this.setSize(300,300);
		this.setTitle("마우스로 그림 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(new MyPanel5());
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Scribble scribble=new Scribble();
	}
}
class MyPanel5 extends JPanel implements MouseMotionListener{
	ArrayList<Rectangle> list=new ArrayList<>();
	public MyPanel5() {
		this.addMouseMotionListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Rectangle r:list) {
			g.drawRect(r.x, r.y, r.w, r.h);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Rectangle r=new Rectangle();
		r.x=e.getX();
		r.y=e.getY();
		r.w=1;
		r.h=1;
		list.add(r);
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
