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
			System.out.println("Ŭ���̾�Ʈ�� ���ӵǾ���... [" + socket.getRemoteSocketAddress());
			//Ŭ���̾�Ʈ�� ��û�� �����Ǹ� ���ο� socket�� ȣ���Ѵ� �ļ���~ .
			//Ŭ���̾�Ʈ�� ����Ѵ�
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(Calendar.getInstance().getTime());
			socket.close();
		}
	}
}