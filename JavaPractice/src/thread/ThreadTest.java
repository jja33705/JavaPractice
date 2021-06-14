package thread;

public class ThreadTest {

	public static void main(String[] args) {
		Thread c1 = new Counter(1);
		Thread c2 = new Counter(11);
		// Runnable�������̽� ����, ThreadŬ���� ���
		c1.start(); //���ο� ������ ����
		c2.start(); //���ο� ������ ����
		System.out.println("main thread ����...");
	}

}

class Counter extends Thread{
	private int start;
	
	public Counter(int start) {
		this.start = start;
	}
	
	@Override
	public void run() {
		for (int i = start; i < (start + 10); i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
			
		}
		System.out.println(start + "~ " + (start+9) + "����  count �����մϴ�.");
	}
}
