package ch11Practice;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawTree extends JFrame {
	public DrawTree() {
		this.setTitle("프랙탈로 나무 그리기");
		this.setSize(500,500);
		this.add(new MyPanel());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
	}
}
