package com.kh.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerPractice {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int port = 3200; //1) �� ���α׷����� ����� port ��ȣ�� ����// ���������� ��� ��Ʈ�� ��θ� ���ڳĴ� �ǹ�
		
		ServerSocket server = null;
		BufferedReader br = null;
		PrintWriter	pw = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �ֽ��ϴ�.");
			Socket socket = server.accept(); //socket == Ŭ���̾�Ʈ�� ����ϱ� ���� ���ϰ�ü�� ������.
			System.out.println(socket.getInetAddress().getHostAddress() +"�� ������ ��û��...");
		//������ �ּҰ��� �������� Ŭ���̾�Ʈ�� �ּҰ��� ������.	
						//������Ʈ��				//������Ʈ��				//�� ��Ʈ��
			 br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//�Է¿� ��Ʈ��.(Ŭ���̾�Ʈ�κ��� ���޹��� ���� ���� ������ �о���� �� ����). 
			// InputStreamReader:reader�� 2����Ʈ�� stream�� 1����Ʈ���� InputStreamReader�� �̿��ؼ�
			 // �߰����� ���� ������.
			 			//������Ʈ��				//������Ʈ��				//�� ��Ʈ��
			 pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			 //��¿� ��Ʈ��.(Ŭ���̾�Ʈ���� ���� ������ �뵵)OutputStreamWriter: 1byte�� 2byte������ ȣȯ�� ������ ������Ʈ��
			 while(true) {
			String message = br.readLine();
			System.out.println("Ŭ���̾�Ʈ�κ��� ���� ���� �޼��� :" + message);
			
			System.out.println("Ŭ���̾�Ʈ���� ���� ����:"); //����� �ְ�޴� �ݺ���.
			
			String sendMessage = in.nextLine();
			
			pw.println(sendMessage);
			
			pw.flush(); //���� ��Ʈ���� �����ִ� �ܿ� �����͸� ������ �������� ����
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			pw.close();
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace(); //��� ���Ḧ ���� �ڿ��ݳ�(������ ������ ��������)
			}
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	} 

}
