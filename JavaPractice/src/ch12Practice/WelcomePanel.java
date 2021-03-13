package ch12Practice;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel {
	public WelcomePanel() {
		JLabel label = new JLabel("자바 피자에 오신 것을 환영합니다.");
		this.add(label);
	}
}
