package com.Package.Socket;

	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.net.InetSocketAddress;
	import java.net.Socket;
import java.util.Scanner;
//192.168.20.16:1818
	public class ClientSocket {

		public static void main(String[] args) {
			System.out.println("클라이언트 입니다.");
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			try{
				System.out.println("접속할 IP 주소 : ");
				String IP = sc1.nextLine();
				System.out.println("접속할 포트 주소 : ");
				int port1 = sc2.nextInt();
				Socket connSock = new Socket(); // 서버에 접속할 때 사용할 소켓 생성
				InetSocketAddress connAddr = new InetSocketAddress(IP, port1);
				connSock.connect(connAddr); // 위에서 결정한 주소로 연결 

				
				OutputStream sender = connSock.getOutputStream(); //소켓으로 데이터를 보내려면 꼭 필요함.
				InputStream receive = connSock.getInputStream();// 소켓에서 데이터를 가져오려면 꼭 필요함.
				byte [] recvBuf = new byte[100];//수신데이터를 담을 저장공간
				String recvMsg;
				String sendBuf;
				
				do {
					receive.read(recvBuf); //소켓에서 수신데이터 가져오기
					recvMsg = new String(recvBuf); //byte배열을 String으로 변환하는 작업
					System.out.println("서버가"+recvMsg+"라고 말합니다."); //가져온거 출력하기
					
					System.out.println("서버에게 전할 말을 적고 Enter");
					sendBuf = sc.nextLine(); // 서버로 보낼 메세지
					sender.write(sendBuf.getBytes());	//서버로 메시지 보내기
					//System.out.println("클라이언트를 종료 하시겠습니까? (Y/N)");
					//sendBuf = sc.nextLine(); // 서버로 보낼 메세지
				} while (true); //sendBuf.equals("y")
				//System.out.println("클라이언트 종료");


				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			

		}

	}