package ch10Practice;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener {
	private MyButton2[][] buttons;
	private int turn=1;
	public TicTacToe() {
		this.setTitle("TIC-TAC-TOE");
		this.setSize(460,460);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3,3,5,5));
		buttons=new MyButton2[3][3];
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				buttons[i][j]=new MyButton2();
				buttons[i][j].setFont(new Font("Serif",Font.BOLD,100));
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TicTacToe ticTacToe=new TicTacToe();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton2 button=(MyButton2)e.getSource();
		if(button.c!=' ') {
			return;
		}
		if(turn%2==0) {
			button.c='X';
		}else {
			button.c='O';
		}
		button.setText(""+button.c);
		turn++;
		for(int i=0;i<buttons.length;i++) {
			boolean x=true, o=true;
			for(int j=0;j<buttons[i].length;j++) {
				if(buttons[i][j].c!='X') {
					x=false;
				}
				if(buttons[i][j].c!='O') {
					o=false;
				}
			}
			if(x) {
				new Prompt("X Win",this.getLocation());
				return;
			}
			if(o) {
				new Prompt("O Win",this.getLocation());
				return;
			}
		}
		for(int i=0;i<buttons.length;i++) {
			boolean x=true, o=true;
			for(int j=0;j<buttons[i].length;j++) {
				if(buttons[j][i].c!='X') {
					x=false;
				}
				if(buttons[j][i].c!='O') {
					o=false;
				}
			}
			if(x) {
				new Prompt("X Win",this.getLocation());
				return;
			}
			if(o) {
				new Prompt("O Win",this.getLocation());
				return;
			}
		}
		boolean x=true, o=true;
		for(int i=0;i<buttons.length;i++) {
			if(buttons[i][i].c!='X') {
				x=false;
			}
			if(buttons[i][i].c!='O') {
				o=false;
			}
		}
		if(x) {
			new Prompt("X Win",this.getLocation());
			return;
		}
		if(o) {
			new Prompt("O Win",this.getLocation());
			return;
		}
		x=true;
		o=true;
		for(int i=0, j=2;i<buttons.length;i++,j--) {
			if(buttons[i][j].c!='X') {
				x=false;
			}
			if(buttons[i][j].c!='O') {
				o=false;
			}
		}
		if(x) {
			new Prompt("X Win",this.getLocation());
			return;
		}
		if(o) {
			new Prompt("O Win",this.getLocation());
			return;
		}
		if(turn>9) {
			new Prompt("¹«½ÂºÎ",this.getLocation());
		}
	}
	
}
class MyButton2 extends JButton {
	char c=' ';
}
class Prompt extends JFrame {
	public Prompt(String s, Point p) {
		this.setSize(200,150);
		this.setTitle("¾Ë¸²");
		this.setLocation(p);
		JPanel panel=new JPanel();
		JLabel label=new JLabel(s);
		label.setFont(new Font(null,Font.BOLD,50));
		panel.add(label);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
