package puzzleGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class PuzzleGame extends JFrame implements ActionListener{
	private JButton[][] buttons;
	private ArrayList<String> list=new ArrayList<>();
	private JButton reset;
	private JPanel center;
	
	public PuzzleGame() {
		center=new JPanel();
		center.setLayout(new GridLayout(3,3));
		buttons=new JButton[3][3];
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				buttons[i][j]=new JButton();
				buttons[i][j].setPreferredSize(new Dimension(100,100));
				buttons[i][j].addActionListener(this);
				center.add(buttons[i][j]);
			}
		}
		setPuzzle();
		this.add(center,BorderLayout.CENTER);
		JPanel south=new JPanel();
		reset=new JButton("reset");
		reset.addActionListener(this);
		south.add(reset);
		this.add(south,BorderLayout.SOUTH);
		this.setTitle("Puzzle Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	private void setPuzzle() {
		for(int i=1;i<9;i++) {
			list.add(String.valueOf(i));
		}
		list.add(" ");
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				int random=(int)(Math.random()*list.size());
				buttons[i][j].setText(list.get(random));
				list.remove(random);
			}
		}
		checkPuzzle();
	}
	
	private void checkPuzzle() {
		boolean end=true;
		String[] puzzle= {"1","2","3","4","5","6","7","8"," "};
		int index=0;
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++, index++) {
				if(buttons[i][j].getText().equals(puzzle[index])) {
					buttons[i][j].setBackground(Color.GREEN);
				}else {
					buttons[i][j].setBackground(null);
					end=false;
				}
			}
		}
		if(end) {
			reset.setText("퍼즐을 풀었습니다.(reset)");
		}
	}
	
	public static void main(String[] args) {
		PuzzleGame puzzleGame=new PuzzleGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s=((JButton)e.getSource()).getText();
		if(s.equals(" ")) {
			return;
		}
		if(s.equals("reset")) {
			setPuzzle();
			return;
		}
		if(s.equals("퍼즐을 풀었습니다.(reset)")) {
			reset.setText("reset");
			setPuzzle();
			return;
		}
		for(int i=0;i<buttons.length;i++) {
			for(int j=0;j<buttons[i].length;j++) {
				if(buttons[i][j].getText().equals(s)) {
					if(i>0 && buttons[i-1][j].getText().equals(" ")) {
						buttons[i][j].setText(buttons[i-1][j].getText());
						buttons[i-1][j].setText(s);
					}else if(i<2 && buttons[i+1][j].getText().equals(" ")) {
						buttons[i][j].setText(buttons[i+1][j].getText());
						buttons[i+1][j].setText(s);
					}else if(j>0 && buttons[i][j-1].getText().equals(" ")) {
						buttons[i][j].setText(buttons[i][j-1].getText());
						buttons[i][j-1].setText(s);
					}else if(j<2 && buttons[i][j+1].getText().equals(" ")) {
						buttons[i][j].setText(buttons[i][j+1].getText());
						buttons[i][j+1].setText(s);
					}
					checkPuzzle();
					return;
				}
			}
		}
	}
}