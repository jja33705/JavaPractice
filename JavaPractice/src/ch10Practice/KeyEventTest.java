package ch10Practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener{
	private JPanel panel;
	private JTextField field;
	private JTextArea area;
	public KeyEventTest() {
		panel=new JPanel(new GridLayout(0,2));
		panel.add(new JLabel("문자를 입력하시오: "));
		field=new JTextField(10);
		panel.add(field);
		area=new JTextArea(3,30);
		this.add(panel,BorderLayout.NORTH);
		this.add(area, BorderLayout.CENTER);
		field.addKeyListener(this);
		this.setTitle("keyEvent test");
		this.setSize(400,200);
		this.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		display(e,"Key Typed            ");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		display(e,"Key Pressed          ");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		display(e, "Key Released        ");
		
	}
	private void display(KeyEvent e, String s) {
		char c=e.getKeyChar();
		int keyCode=e.getKeyCode();
		String modifiers="Alt: "+e.isAltDown()+"Ctrl: "+e.isControlDown()+"Shift: "+e.isShiftDown();
		area.append(" "+s+"문자 "+c+"(코드: "+keyCode+") "+modifiers+"\n");
	}
	public static void main(String[] args) {
		KeyEventTest keyEventTest=new KeyEventTest();
	}

}
