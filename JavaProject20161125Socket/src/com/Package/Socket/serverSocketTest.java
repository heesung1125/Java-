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
			System.out.println("���� �Դϴ�.");
			ServerSocket serverSock = new ServerSocket(); //������ ���� ����
			InetSocketAddress serveraddr = new InetSocketAddress("127.0.0.1", 1818); //������ IP�ּҿ� ��Ʈ��ȣ�� ����			
			serverSock.bind(serveraddr); // �������Ͽ� ������ ������ �ּ�("IP",Port)�� ����Ѵ�.
			
			Socket cliScok1 = serverSock.accept();//���� �������� ã�ƿ� ���� ������ �������� ���������.
			//Ŭ���̾�Ʈ �����û�� ó�� �� �غ�... ��� ���� Ŭ���̾�Ʈ�� ���� ��û�� Ŭ���̾�Ʈ�� cliScok1���� �Ѱ��ְ� serverSock�� Listening ���·� ��ȯ�Ѵ�.

			OutputStream sender = cliScok1.getOutputStream(); //Ŭ���̾�Ʈ ������ ���� �غ�
			InputStream receiver = cliScok1.getInputStream(); // Ŭ���̾�Ʈ ������ ���� �غ�
			byte[] recvBuf = new byte[100];				// Ŭ���̾�Ʈ�� ���� �����͸� ���� ���� ����.
			String recvMsg;		// byte�迭�� ���ŵ� �����͸� String �ڷ������� ��ȯ�ϴ� �۾�.
			
		
			do {
				String sendMsg = sc.nextLine();		// Ŭ���̾�Ʈ�� ���� ȯ�� �޽���.	
				sender.write(sendMsg.getBytes());	// Ŭ���̾�Ʈ�� ȯ���޽��� �����ϱ�.
				System.out.println("Ŭ���̾�Ʈ ���� : "+sendMsg);//Ŭ���̾�Ʈ�� ���� ������ ȭ�鿡 ����ϱ�.
				
				
				receiver.read(recvBuf); 					// ���Ͽ��� ���� ������ ��������
				recvMsg = new String(recvBuf);		// byte�迭�� ���ŵ� �����͸� String �ڷ������� ��ȯ�ϴ� �۾�.
				System.out.println("Ŭ���̾�Ʈ �� : "+recvMsg+"��� �մϴ�.");	//������ ������ ȭ�鿡 ����ϱ�.
			} while (true); //recvMsg.equals("y")
			//System.out.println("���� ����");

			
			
			
			
			//serverSock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
