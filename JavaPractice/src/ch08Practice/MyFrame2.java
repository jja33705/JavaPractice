package ch08Practice;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame2 extends JFrame{
	public MyFrame2() {
		this.setSize(300,200);
		this.setTitle("MyFrame2");
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		for(int i=0;i<10;i++) {
			panel.add(new JButton("Button"+i));
		}
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame2 myFrame=new MyFrame2();
	}
}
