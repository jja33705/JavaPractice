package ch12Practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConverter extends JFrame implements ActionListener, KeyListener {
	private JTextArea input, output;
	private JButton translate, cancle;
	
	public TextConverter() {
		this.setTitle("한글-영어 번역");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(1, 2, 20, 20));
		input = new JTextArea(20, 28);
		input.addKeyListener(this);
		input.setLineWrap(true);
		textPanel.add(input);
		output = new JTextArea(20, 28);
		output.setLineWrap(true);
		output.setEditable(false);
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

		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextConverter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(input.getText().trim().length() == 0) return;
		if(e.getSource() == translate) {
			output.setText(ApiExamTranslateNmt.translate(input.getText()));
		} else if(e.getSource() == cancle) {
			output.setText(null);
			input.setText(null);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(input.getText().trim().length() == 0) return;
		if(input.getText() == null) return;
		if(input.getText().trim() == "") return;
		output.setText(ApiExamTranslateNmt.translate(input.getText()));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
