package ch10Practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyButton extends JButton{
	private static int count=0;
	int index;
	public MyButton(String s) {
		super(s);
		index=count++;
	}
}
public class Puzzle extends JFrame implements ActionListener{
	MyButton[] buttons;
	public Puzzle() {
		this.setSize(300,300);
		this.setTitle("Puzzle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(0,3,2,2));
		buttons=new MyButton[9];
		for(int i=0;i<8;i++) {
			buttons[i]=new MyButton(""+(i+1));
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		buttons[8]=new MyButton(" ");
		buttons[8].addActionListener(this);
		panel.add(buttons[8]);
		this.add(panel,BorderLayout.CENTER);
		JPanel resetPanel=new JPanel();
		JButton reset=new MyButton("reset");
		resetPanel.add(reset);
		this.add(resetPanel,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Puzzle puzzle=new Puzzle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton button=(MyButton)e.getSource();
		if(button.getText().equals(" ")) {
			return;
		}
		if(button.index==0) {
			
		}
	}

}
