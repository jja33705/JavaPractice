package ch13Practice;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Racket extends Rectangle implements KeyListener {
	public static final int WIDTH = 20;
	public static final int HEIGHT = 100;
	private PingPong game;
	private Color color;
	private int x, y;
	private int ySpeed = 0;
	private int id;
	
	public Racket(PingPong game, Color color, int x, int y, int id) {
		super.x = x;
		super.width = WIDTH;
		super.height= HEIGHT;
		this.game = game;
		this.color = color;
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void move() {
		if(y + ySpeed >=0 && y + ySpeed <= game.getHeight() - HEIGHT) {
			y += ySpeed;
		}
		super.y = y;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(this.id == 1) {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				ySpeed = -5;
			} else if(e.getKeyCode() == KeyEvent.VK_S) {
				ySpeed = 5;
			}
		} else if(this.id == 2) {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				ySpeed = -5;
			} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				ySpeed = 5;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ySpeed = 0;
		
	}
}
