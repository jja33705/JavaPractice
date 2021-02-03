package ch10Practice;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Counter extends JFrame implements ActionListener{
	private int count=0;
	private JLabel label;
	private JButton countDown;
	private JButton countUp;
	private JButton reset;
	public Counter() {
		JPanel panel=new JPanel();
		countDown=new JButton("카운터 감소");
		countDown.addActionListener(this);
		panel.add(countDown);
		JLabel name=new JLabel("Counter");
		panel.add(name);
		label=new JLabel(""+count);
		label.setFont(new Font("Serif",Font.BOLD,100));
		panel.add(label);
		countUp=new JButton("카운터 증가");
		countUp.addActionListener(this);
		panel.add(countUp);
		reset=new JButton("리셋");
		reset.addActionListener(this);
		this.add(reset,BorderLayout.SOUTH);
		this.add(panel);
		this.setSize(400,200);
		this.setTitle("My Counter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Counter counter=new Counter();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==countUp) {
			label.setText(""+(++count));
		}
		if(e.getSource()==countDown) {
			label.setText(""+(--count));
		}
		if(e.getSource()==reset) {
			count=0;
			label.setText(""+count);
		}
	}
}
