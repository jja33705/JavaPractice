package ch08Practice;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame3 extends JFrame{
	private JPanel panel;
	private JLabel[] labels;
	public MyFrame3() {
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		labels=new JLabel[30];
		for(int i=0;i<30;i++) {
			labels[i]=new JLabel(""+i);
			int x=(int)(500*Math.random());
			int y=(int)(200*Math.random());
			labels[i].setForeground(Color.MAGENTA);
			labels[i].setBounds(x, y, 20, 20);
			panel.add(labels[i]);
		}
		this.setSize(500,300);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame3 myframe=new MyFrame3();
	}
}
