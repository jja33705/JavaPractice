package ch12Practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaFrame extends JFrame implements ActionListener{
	private JTextField field;
	private JTextArea area;
	
	public TextAreaFrame() {
		this.setTitle("Text Area Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		field = new JTextField(30);
		field.addActionListener(this);
		this.add(field, BorderLayout.NORTH);
		
		area = new JTextArea(10, 30);
		area.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(area);
		this.add(scrollPane, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TextAreaFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = field.getText();
		area.append(text + "\n");
		field.selectAll();
//		area.setCaretPosition(area.getDocument().getLength());
	}

}
