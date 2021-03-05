package ch11Practice;

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

public class Animation extends JPanel implements ActionListener {
	
	private final int WIDTH = 500, HEIGHT = 300;
	private BufferedImage image;
	private Timer timer;
	private int x, y;
	private final int START_X = 10, START_Y = 200;
	private boolean xIncrease = true;
	private boolean yIncrease = false;
	
	public Animation() {
		File file = new File("spaceship.png");
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		x = START_X;
		y = START_Y;
		timer = new Timer(20, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (x == 0 || x == WIDTH-image.getWidth()-15)
			xIncrease = !xIncrease;
		if (y == 0 || y == HEIGHT-image.getHeight()-35)
			yIncrease = !yIncrease;
		x = xIncrease ? x+1 : x-1;
		y = yIncrease ? y+1 : y-1 ;
		repaint();
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.add(new Animation());
		frame.setTitle("애니메이션 테스트");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500,300);
		frame.setVisible(true);
	}
}
