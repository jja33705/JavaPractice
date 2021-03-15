package ch12Practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConverter extends JFrame implements ActionListener {
	private JTextArea input, output;
	private JButton translate, cancle;
	
	public TextConverter() {
		this.setTitle("한글-영어 번역");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2, 20, 20));
		input = new JTextArea(10, 14);
		input.setLineWrap(true);
		textPanel.add(input);
		output = new JTextArea(10, 14);
		output.setLineWrap(true);
		output.setEnabled(false);
		textPanel.add(output);
		this.add(textPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		translate = new JButton("변환");
		translate.addActionListener(this);
		buttonPanel.add(translate);
		cancle = new JButton("취소");
		cancle.addActionListener(this);
		buttonPanel.add(cancle);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextConverter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == translate) {
			output.setText(ApiExamTranslateNmt.translate(input.getText()));
		} else if(e.getSource() == cancle) {
			input.setText(null);
			output.setText(null);
		}
		
	}
}
