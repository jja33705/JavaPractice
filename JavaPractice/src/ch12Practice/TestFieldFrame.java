package ch12Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestFieldFrame extends JFrame implements ActionListener{
	private JButton button;
	private JTextField text, result;
	
	public TestFieldFrame() {
		this.setSize(280,130);
		this.setTitle("제곱 계산하기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("숫자 입력: "));
		text = new JTextField(15);
		text.addActionListener(this);
		panel.add(text);
		
		panel.add(new JLabel("제곱한 값: "));
		result = new JTextField(15);
		result.setEditable(false);
		panel.add(result);
		
		button = new JButton("OK"); 
		button.addActionListener(this);
		panel.add(button);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button || e.getSource() == text) {
			String value = text.getText();
			int number = Integer.parseInt(value);
			result.setText(""+number * number);
		}
		
	}
	
	public static void main(String[] args) {
		new TestFieldFrame();
	}

}
