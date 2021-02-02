package ch10Practice;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine extends JFrame implements ActionListener{
	private JLabel[] labels;
	private JButton button;
	private int[] numbers;
	
	public SlotMachine() {
		this.setTitle("My Game");
		this.setSize(500,300);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		numbers=new int[3];
		labels=new JLabel[3];
		for(int i=0;i<labels.length;i++) {
			labels[i]=new JLabel();
			labels[i].setFont(new Font("Serif",Font.BOLD,100));
			labels[i].setSize(100,100);
			labels[i].setText(""+numbers[i]);
			labels[i].setLocation(100+100*i,50);
			panel.add(labels[i]);
		}
		button=new JButton("½ºÇÉ");
		button.setBounds(100, 175, 250, 50);
		button.addActionListener(this);
		panel.add(button);
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<labels.length;i++) {
			numbers[i]=(int)(Math.random()*10);
			labels[i].setText(""+numbers[i]);
		}
	}
	
	public static void main(String[] args) {
		SlotMachine slotMachine=new SlotMachine();
	}
}
