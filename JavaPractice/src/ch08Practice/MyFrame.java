package ch08Practice;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	public MyFrame() {
		JPanel panel=new JPanel();
		JPanel panelA=new JPanel();
		JLabel label=new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
		panelA.add(label);
		panelA.setBackground(Color.CYAN);
		panel.add(panelA);
		JPanel panelB=new JPanel();
		JButton button1=new JButton("콤보피자");
		panelB.add(button1);
		JButton button2=new JButton("포테이토피자");
		panelB.add(button2);
		JButton button3=new JButton("불고기피자");
		panelB.add(button3);
		JLabel count=new JLabel("개수");
		panelB.add(count);
		JTextField textField=new JTextField(10);
		panelB.add(textField);
		panelB.setBackground(Color.GREEN);
		panel.add(panelB);
		panel.setBackground(Color.BLUE);
		this.add(panel);
		this.setTitle("MyFrame");
		this.setSize(500, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame myFrame=new MyFrame();
	}
}
