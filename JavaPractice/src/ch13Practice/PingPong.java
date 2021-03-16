package ch13Practice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PingPong extends JPanel implements KeyListener{
	private Ball ball;
	private Racket racket1, racket2;
	private Score score;
	private boolean isCollision = false;
	int p1Score = 0;
	int p2Score = 0;
	
	public PingPong() {
		this.setBackground(Color.GREEN);
		
		ball = new Ball(Color.WHITE, 440, 240);
		
		racket1 = new Racket(this, Color.BLUE, 0, 200, 1);
		racket2 = new Racket(this, Color.RED, 865, 200, 2);
		
		score = new Score(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		ball.draw(g2d);
		racket1.draw(g2d);
		racket2.draw(g2d);
		score.draw(g2d);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Å¹±¸ °ÔÀÓ");
		frame.setSize(900, 500);
		PingPong pingPong = new PingPong();
		frame.add(pingPong);
		frame.addKeyListener(pingPong);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		while(true) {
			try {
				pingPong.collision();
				pingPong.move();
				pingPong.repaint();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void move() {
		ball.move();
		racket1.move();
		racket2.move();
	}
	
	private void collision() {
		if(ball.intersects(racket1) || ball.intersects(racket2)) {
			if(isCollision == false) {
				ball.xSpeed += ball.xSpeed>0 ? 1 : -1;
				ball.ySpeed += ball.ySpeed>0 ? 1 : -1;
				ball.xSpeed = -ball.xSpeed;
				isCollision = true;
			} 
		} else {
			isCollision = false;
		}
		if(ball.y + ball.ySpeed < 0 || ball.y + ball.ySpeed + Ball.RADIUS * 2> this.getHeight()) {
			ball.ySpeed = -ball.ySpeed;
		}
		if(ball.x + ball.xSpeed < 0) {
			p2Score +=1;
			ball = new Ball(Color.WHITE, 440, 240);
			ball.xSpeed = -ball.xSpeed;
		}
		if(ball.x + ball.xSpeed + Ball.RADIUS * 2 > this.getWidth()) {
			p1Score +=1;
			ball = new Ball(Color.WHITE, 440, 240);
			ball.xSpeed = -ball.xSpeed;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		racket1.keyPressed(e);
		racket2.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racket1.keyReleased(e);
		racket2.keyReleased(e);
	}
}