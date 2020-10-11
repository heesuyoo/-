package client;

import java.io.IOException;
import java.net.Socket;

public class MainClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = null;
			socket = new Socket("192.168.0.15", 1234); // ���� ������ ���� 
			System.out.println("������ ���� ����!"); // ���� Ȯ�ο�
			
			ListeningThread t1 = new ListeningThread(socket); // �������� ���� �޼��� �д� Thread
			WritingThread t2 = new WritingThread(socket); // ������ �޼��� ������ Thread

			t1.start(); // ListeningThread Start
			t2.start(); // WritingThread Start
            
		} catch (IOException e) {
			e.printStackTrace(); // ����ó��
		}
	}
}

