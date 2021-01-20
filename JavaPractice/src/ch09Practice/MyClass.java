package ch09Practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClass implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("beep");
	}
}
