package ch13Practice;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Rectangle {
	public static final int RADIUS = 20;
	private Color color;
	int x, y;
	int xSpeed = Math.random() * 2 > 1 ? 1 : -1; ;
	int ySpeed = Math.random() * 2 > 1 ? 1 : -1; ;
	
	public Ball(Color color, int x, int y) {
		super.width = RADIUS * 2;
		super.height = RADIUS * 2;
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public void move() {
		x += xSpeed;
		y += ySpeed;
		super.x = x;
		super.y = y;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillOval(x, y, RADIUS * 2, RADIUS * 2);
	}
}
