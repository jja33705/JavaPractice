package ch10Practice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JFrame implements ActionListener{
	private JTextField textField;
	private JPanel panel;
	public KeyPad() {
		textField=new JTextField();
		this.add(textField,BorderLayout.NORTH);
		panel=new JPanel();
		panel.setLayout(new GridLayout(3,3));
		this.add(panel,BorderLayout.CENTER);
		for(int i=1;i<=9;i++) {
			JButton button=new JButton(""+i);
			button.addActionListener(this);
			button.setPreferredSize(new Dimension(100,100));
			panel.add(button);
		}
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand=e.getActionCommand();
		textField.setText(textField.getText()+actionCommand);
	}
	public static void main(String[] args) {
		KeyPad keyPad=new KeyPad();
	}

}
