package ch10Practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActionEventTest1 extends JFrame {
	private JButton button;
	private JLabel label;
	public ActionEventTest1() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		JPanel panel=new JPanel();
		button=new JButton("버튼을 누르시오.");
		label=new JLabel("아직 버튼이 눌려지지 않았습니다.");
		button.addActionListener(new MyListener());
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ActionEventTest1 t=new ActionEventTest1();
	}
}