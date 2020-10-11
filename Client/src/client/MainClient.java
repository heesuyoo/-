package client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = null;
			socket = new Socket("192.168.0.15", 1234); // 소켓 서버에 접속 
			System.out.println("서버에 접속 성공!"); // 접속 확인용
			
			ListeningThread t1 = new ListeningThread(socket); // 서버에서 보낸 메세지 읽는 Thread
			WritingThread t2 = new WritingThread(socket); // 서버로 메세지 보내는 Thread

			t1.start(); // ListeningThread Start
			t2.start(); // WritingThread Start
            
		} catch (IOException e) {
			e.printStackTrace(); // 예외처리
		}
	}
}

