package com.kh.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientPractice {
	public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in);
	
	String ServerIP = "192.168.40.22"; //1. �����ϰ��� �ϴ� ������ Ip�ּ� ,port��ȣ ����
	int port = 3200;
	
	BufferedReader	br =null;
	PrintWriter pw = null;
	Socket socket = null;
	try {
	socket = new Socket(ServerIP,port); //Socket ��ü ���� .������ ������ ��쿡�� null���� ���.
		
		if(socket != null) { //������ �� �Ǿ��� ��� => �������!
			System.out.println("������ ���� ����!");
		}
				//�Է¿� ��Ʈ�� ���� //������Ʈ���� �߰��Ͽ� ���ɰ���
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//��¿� ��Ʈ������
		pw = new PrintWriter(new  OutputStreamWriter(socket.getOutputStream()));
	 
		while(true) {
			System.out.print("�������� ��������:");
			
			String sendMessage = in.nextLine();
			
			pw.println(sendMessage);
			
			pw.flush();
			
			String message = br.readLine(); //�����κ��� ���޵� �޼����� �о���̱�.
			
			System.out.println("�����κ��� ���� ���� �޽���  : " + message);
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally { //�������(������ ������ ��������)
		pw.close();
		try {
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
	
}
