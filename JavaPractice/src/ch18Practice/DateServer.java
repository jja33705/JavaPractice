package ch18Practice;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class DateServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9100);
		
		while(true) {
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��ϴ�...");
			//Ŭ���̾�Ʈ ��û�� ��ٸ���.
			Socket socket = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ���... [" + socket.getRemoteSocketAddress() + "]");
			
			// Ŭ���̾�Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ������ �� Ŭ���̾�Ʈ�� ����Ѵ�.
			
			Thread thread = new NewSocket(socket);
			thread.start();
		}
	}
}

class NewSocket extends Thread{
	Socket socket;
	public NewSocket(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			//Ŭ���̾�Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ������ �� Ŭ���̾�Ʈ�� ����Ѵ�.
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println(Calendar.getInstance().getTime());
			Thread.sleep(1000*10);
			writer.println("Hello?");
			socket.close();
			System.out.println("Ŭ���̾�Ʈ���� ������ �����մϴ�.");
		} catch (Exception e) {
			
		} finally {
			try {
				socket.close();
			} catch (Exception ignore) {}
		}
	}
	
}