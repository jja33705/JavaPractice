package ch18Practice;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class DateServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9100);
		
		while(true) {
			System.out.println("클라이언트의 요청을 기다립니다...");
			//클라이언트 요청을 기다린다.
			Socket socket = serverSocket.accept();
			System.out.println("클라이언트가 접속되었읍... [" + socket.getRemoteSocketAddress() + "]");
			
			// 클라이언트와 요청이 설립되면 새로운 socket을 생성해 그 클라이언트와 통신한다.
			
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
			//클라이언트와 요청이 설립되면 새로운 socket을 생성해 그 클라이언트와 통신한다.
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println(Calendar.getInstance().getTime());
			Thread.sleep(1000*10);
			writer.println("Hello?");
			socket.close();
			System.out.println("클라이언트와의 연결을 종료합니다.");
		} catch (Exception e) {
			
		} finally {
			try {
				socket.close();
			} catch (Exception ignore) {}
		}
	}
	
}