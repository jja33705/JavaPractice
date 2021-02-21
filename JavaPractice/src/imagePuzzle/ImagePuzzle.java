package imagePuzzle;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePuzzle extends JFrame implements ActionListener{
	private int pieces = 4;
	private int totalPieces = pieces * pieces;
	private BufferedImage img;
	private ArrayList<Integer> pieceNums = new ArrayList<>();
	
	public static void main(String[] args) {
		new ImagePuzzle();
	}
	
	public ImagePuzzle( ) {
		this.setTitle("Puzzle Game");
		try {
			img = ImageIO.read(new File("galaxy.jpg"));
		} catch(IOException e) {
			e.printStackTrace(); //ø°∑ØªÁ¿Ø∞° «¡∏∞∆Æµ 
			System.exit(1);
		}
		
		for (int i = 0; i < totalPieces; i++)
			pieceNums.add(i);
		
		this.add(new ImagePanel(), BorderLayout.CENTER);
		JButton imgDivideBtn = new JButton("¿ÃπÃ¡ˆ ¬…∞≥±‚");
		this.add(imgDivideBtn, BorderLayout.SOUTH);
		
		imgDivideBtn.addActionListener(this);
		this.setSize(img.getWidth(), img.getHeight()+65);
		this.setVisible(true);
	}
	
	private void shuffle() {
		Collections.shuffle(pieceNums); // ºØæÓ¡‹
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		shuffle();
		repaint();
	}
	class ImagePanel extends JPanel implements MouseMotionListener, MouseListener{
		private int pieceWidth = img.getWidth() / pieces;
		private int pieceHeight = img.getHeight() / pieces;
		private Point pressedPoint=new Point();
		private Point draggedPoint=new Point();
		
		public ImagePanel() {
			this.addMouseMotionListener(this);
			this.addMouseListener(this);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int changeX = draggedPoint.x - pressedPoint.x;
			int changeY = draggedPoint.y - pressedPoint.y;
			
			
			for (int x = 0; x < pieces; x++) {	
				for (int y = 0; y < pieces; y++) {
					int sx = pieceNums.get(x * pieces + y) / pieces * pieceWidth;
					int sy = pieceNums.get(x * pieces + y) % pieces * pieceHeight;
					
					int dx = x * pieceWidth;
					int dy = y * pieceHeight;
					if(x == pressedPoint.x / pieceWidth && y == pressedPoint.y / pieceHeight) {
						g.drawImage(img, dx+changeX, dy+changeY, dx+pieceWidth+changeX, dy+pieceHeight+changeY, sx, sy, sx+pieceWidth, sy+pieceHeight, null);
					} else {
						g.drawImage(img, dx, dy, dx+pieceWidth, dy+pieceHeight, sx, sy, sx+pieceWidth, sy+pieceHeight, null);
					}
				}
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			draggedPoint.x = e.getX();
			draggedPoint.y = e.getY();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			pressedPoint.x = e.getX();
			pressedPoint.y = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int pressedImg = pieceNums.get(pressedPoint.x/pieceWidth*pieces + pressedPoint.y/pieceHeight);
			int releasedImg = pieceNums.get(e.getX()/pieceWidth*4 + e.getY()/pieceHeight);
			pieceNums.set(pressedPoint.x/pieceWidth*pieces + pressedPoint.y/pieceHeight, releasedImg);
			pieceNums.set(e.getX()/pieceWidth*4 + e.getY()/pieceHeight, pressedImg);
			pressedPoint = new Point();
			draggedPoint = new Point();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
}
