package ch08Practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mylab extends JFrame{
	public Mylab() {
		JPanel panel=new JPanel();
		this.add(panel);
		
		JLabel label1=new JLabel("È­¾¾ ¿Âµµ");
		JLabel label2=new JLabel("¼·¾¾ ¿Âµµ");
		JTextField field1=new JTextField(15);
		JTextField field2=new JTextField(15);
		JButton button=new JButton("º¯È¯");
		
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
		
		this.setTitle("¿Âµµº¯È¯±â");
		this.setSize(280,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Mylab mylab=new Mylab();
	}
}
