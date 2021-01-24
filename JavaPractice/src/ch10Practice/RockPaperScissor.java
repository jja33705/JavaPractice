package ch10Practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RockPaperScissor extends JFrame implements ActionListener{
	static final int ROCK=0;
	static final int PAPER=1;
	static final int SCISSOR=2;
	private JTextField result;
	private JButton rock;
	private JButton paper;
	private JButton scissor;
	public RockPaperScissor() {
		this.setSize(400,300);
		this.setTitle("RockPaperScissor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField information=new JTextField("아래의 버튼 중에서 하나를 클릭하시오!");
		this.add(information,BorderLayout.NORTH);
		JPanel select=new JPanel();
		select.setLayout(new GridLayout(0,3));
		rock=new JButton("ROCK");
		rock.addActionListener(this);
		select.add(rock);
		paper=new JButton("PAPER");
		paper.addActionListener(this);
		select.add(paper);
		scissor=new JButton("SCISSOR");
		scissor.addActionListener(this);
		select.add(scissor);
		this.add(select,BorderLayout.CENTER);result=new JTextField();
		this.add(result,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		RockPaperScissor rockPaperScissor=new RockPaperScissor();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Random random=new Random();
		int computer=random.nextInt(3);
		if(e.getSource()==rock) {
			if(computer==ROCK) {
				result.setText("비겼음");
			}
			if(computer==PAPER) {
				result.setText("컴퓨터 승리");
			}
			if(computer==SCISSOR) {
				result.setText("사용자 승리");
			}
		}
		if(e.getSource()==paper) {
			if(computer==ROCK) {
				result.setText("사용자 승리");
			}
			if(computer==PAPER) {
				result.setText("비겼음");
			}
			if(computer==SCISSOR) {
				result.setText("컴퓨터 승리");
			}
		}
		if(e.getSource()==scissor) {
			if(computer==ROCK) {
				result.setText("컴퓨터 승리");
			}
			if(computer==PAPER) {
				result.setText("사용자 승리");
			}
			if(computer==SCISSOR) {
				result.setText("비겼음");
			}
		}
	}

}
