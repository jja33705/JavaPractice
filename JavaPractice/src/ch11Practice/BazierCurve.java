package ch11Practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BazierCurve extends JFrame implements MouseListener, MouseMotionListener {
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int dragIndex = -1;
	
	public BazierCurve() {
		this.setSize(500, 400);
		this.setTitle("배지어 곡선 그리기");
		JPanel panel = new BezierPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	class BezierPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.BLACK);
			GeneralPath path = new GeneralPath();
			path.moveTo(xs[0], ys[0]);
			path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
			g2d.draw(path);
			
			for (int i = 0; i < 4; i++) {
				if(i % 2 == 0) {
					g2d.setColor(Color.BLUE);
				} else {
					g2d.setColor(Color.RED);
				}
				Rectangle2D rectangle = new Rectangle2D.Float(xs[i], ys[i], 16, 16);
				g2d.fill(rectangle);
			}
		}
	}
	
	public static void main(String[] args) {
		new BazierCurve();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragIndex != -1) {
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < 4; i++) {
			if ((e.getX() >= xs[i]) && (e.getX() <= xs[i] + 16) && (e.getY() >= ys[i]) && (e.getY() <= ys[i] + 16)) {
				dragIndex = i;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		dragIndex = -1;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
