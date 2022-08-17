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
	
	String ServerIP = "192.168.40.22"; //1. 접속하고자 하는 서버의 Ip주소 ,port번호 지정
	int port = 3200;
	
	BufferedReader	br =null;
	PrintWriter pw = null;
	Socket socket = null;
	try {
	socket = new Socket(ServerIP,port); //Socket 객체 생성 .연결이 실패한 경우에는 null값이 담김.
		
		if(socket != null) { //연결이 잘 되었을 경우 => 통신진행!
			System.out.println("서버와 연결 성공!");
		}
				//입력용 스트림 생성 //보조스트림을 추가하여 성능개선
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//출력용 스트림생성
		pw = new PrintWriter(new  OutputStreamWriter(socket.getOutputStream()));
	 
		while(true) {
			System.out.print("서버에게 보낼내용:");
			
			String sendMessage = in.nextLine();
			
			pw.println(sendMessage);
			
			pw.flush();
			
			String message = br.readLine(); //서버로부터 전달된 메세지를 읽어들이기.
			
			System.out.println("서버로부터 전달 받은 메시지  : " + message);
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally { //통신종료(생성된 순서의 역순으로)
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
