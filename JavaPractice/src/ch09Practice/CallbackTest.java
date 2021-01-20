package ch09Practice;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class CallbackTest {

	public static void main(String[] args) {
		ActionListener listener=new MyClass();
		Timer t=new Timer(1000,listener);
		t.start();
		for(int i=0;i<1000;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
			}
		}
	}

}
