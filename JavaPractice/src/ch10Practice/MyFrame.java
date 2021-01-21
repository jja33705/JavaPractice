package ch10Practice;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		JButton button=new JButton("동작");
		button.addActionListener((e)->{System.out.println("버튼이 클릭됐습니다.");});
		this.add(button);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyFrame myFrame=new MyFrame();
	}
}
