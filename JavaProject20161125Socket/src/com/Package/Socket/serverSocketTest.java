package com.Package.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverSocketTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			System.out.println("서버 입니다.");
			ServerSocket serverSock = new ServerSocket(); //서버용 소켓 생성
			InetSocketAddress serveraddr = new InetSocketAddress("127.0.0.1", 1818); //서비스할 IP주소와 포트번호를 설정			
			serverSock.bind(serveraddr); // 서버소켓에 위에서 설정한 주소("IP",Port)를 등록한다.
			
			Socket cliScok1 = serverSock.accept();//서버 소켓으로 찾아온 고객을 고객전용 소켓으로 연결시켜줌.
			//클라이언트 연결요청을 처리 할 준비... 계속 들어올 클라이언트를 위해 요청온 클라이언트를 cliScok1으로 넘겨주고 serverSock은 Listening 상태로 전환한다.

			OutputStream sender = cliScok1.getOutputStream(); //클라이언트 데이터 전송 준비
			InputStream receiver = cliScok1.getInputStream(); // 클라이언트 데이터 수신 준비
			byte[] recvBuf = new byte[100];				// 클라이언트가 보낸 데이터를 담을 공간 설정.
			String recvMsg;		// byte배열로 수신된 데이터를 String 자료형으로 변환하는 작업.
			
		
			do {
				String sendMsg = sc.nextLine();		// 클라이언트로 보낼 환영 메시지.	
				sender.write(sendMsg.getBytes());	// 클라이언트로 환영메시지 전송하기.
				System.out.println("클라이언트 에게 : "+sendMsg);//클라이언트로 보낸 데이터 화면에 출력하기.
				
				
				receiver.read(recvBuf); 					// 소켓에서 수신 데이터 가져오기
				recvMsg = new String(recvBuf);		// byte배열로 수신된 데이터를 String 자료형으로 변환하는 작업.
				System.out.println("클라이언트 가 : "+recvMsg+"라고 합니다.");	//수신한 데이터 화면에 출력하기.
			} while (true); //recvMsg.equals("y")
			//System.out.println("서버 종료");

			
			
			
			
			//serverSock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
