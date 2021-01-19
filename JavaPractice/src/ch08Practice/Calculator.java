package ch08Practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	private JPanel panel=new JPanel();
	private JTextField textField=new JTextField(35);
	private JButton[] buttons=new JButton[25];
	private String[] labels= {"Backspace","","","CE","C","7","8","9","/","sqrt","4","5","6","x","%","1","2","3","-","1/x","0","+/-",".","+","="};
	public Calculator() {
		this.setTitle("Calculator");
		textField.setText("0.");
		textField.setEnabled(false);
		this.add(textField,BorderLayout.PAGE_START);
		panel.setLayout(new GridLayout(0,5,3,3));
		for(int i=0;i<25;i++) {
			buttons[i]=new JButton(labels[i]);
			if(i%5<3) {
				buttons[i].setForeground(Color.BLUE);
			}else {
				buttons[i].setForeground(Color.RED);
			}
			buttons[i].setBackground(Color.YELLOW);
			panel.add(buttons[i]);
		}
		this.add(panel,BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	public static void main(String[] args) {
		Calculator calculator=new Calculator();
	}
}
