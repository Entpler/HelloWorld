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
		
		int port = 3200; //1) 이 프로그램에서 사용할 port 번호를 지정// 서버측에서 몇번 포트로 통로를 열겠냐는 의미
		
		ServerSocket server = null;
		BufferedReader br = null;
		PrintWriter	pw = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("클라이언트의 요청을 기다리고 있습니다.");
			Socket socket = server.accept(); //socket == 클라이언트와 통신하기 위한 소켓객체가 생성됨.
			System.out.println(socket.getInetAddress().getHostAddress() +"가 연결을 요청함...");
		//소켓의 주소값을 가져오고 클라이언트의 주소값을 가져옴.	
						//보조스트림				//보조스트림				//주 스트림
			 br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//입력용 스트림.(클라이언트로부터 전달받은 값을 한줄 단위로 읽어들일 수 있음). 
			// InputStreamReader:reader는 2바이트고 stream은 1바이트여서 InputStreamReader를 이용해서
			 // 중간에서 연결 시켜줌.
			 			//보조스트림				//보조스트림				//주 스트림
			 pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			 //출력용 스트림.(클라이언트에게 값을 전달할 용도)OutputStreamWriter: 1byte와 2byte사이의 호환이 가능한 보조스트림
			 while(true) {
			String message = br.readLine();
			System.out.println("클라이언트로부터 전달 받은 메세지 :" + message);
			
			System.out.println("클라이언트에게 보낼 내용:"); //통신을 주고받는 반복문.
			
			String sendMessage = in.nextLine();
			
			pw.println(sendMessage);
			
			pw.flush(); //현재 스트림에 남아있는 잔여 데이터를 강제로 내보내는 역할
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			pw.close();
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace(); //통신 종료를 위한 자원반납(생성된 순서의 역순으로)
			}
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	} 

}
