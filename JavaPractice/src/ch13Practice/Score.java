package ch13Practice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score {
	private PingPong game;
	
	public Score(PingPong game) {
		this.game = game;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.drawLine(435, 0, 435, 500);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Serif",  Font.BOLD, 50));
		g2d.drawString(""+game.p1Score/10 + game.p1Score%10, 350, 50);
		g2d.drawString(""+game.p2Score/10 + game.p2Score%10, 460, 50);
	}
}
