package ch10Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActionEventTest2 extends JFrame{
	private JButton button;
	private JLabel label;
	public ActionEventTest2() {
		this.setSize(200,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		JPanel panel=new JPanel();
		button=new JButton("버튼을 누르시오.");
		label=new JLabel("아직 버튼이 눌러지지 않았습니다.");
		button.addActionListener(new MyListener());
		panel.add(button);
		panel.add(label);
		this.add(panel);
		this.setVisible(true);
	}
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				label.setText("마침내 버튼이 눌러졌습니다.");
			}
		}
	}

	public static void main(String[] args) {
		ActionEventTest2 t=new ActionEventTest2();
	}

}
