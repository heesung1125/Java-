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
			System.out.println("Ŭ���̾�Ʈ �Դϴ�.");
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			try{
				System.out.println("������ IP �ּ� : ");
				String IP = sc1.nextLine();
				System.out.println("������ ��Ʈ �ּ� : ");
				int port1 = sc2.nextInt();
				Socket connSock = new Socket(); // ������ ������ �� ����� ���� ����
				InetSocketAddress connAddr = new InetSocketAddress(IP, port1);
				connSock.connect(connAddr); // ������ ������ �ּҷ� ���� 

				
				OutputStream sender = connSock.getOutputStream(); //�������� �����͸� �������� �� �ʿ���.
				InputStream receive = connSock.getInputStream();// ���Ͽ��� �����͸� ���������� �� �ʿ���.
				byte [] recvBuf = new byte[100];//���ŵ����͸� ���� �������
				String recvMsg;
				String sendBuf;
				
				do {
					receive.read(recvBuf); //���Ͽ��� ���ŵ����� ��������
					recvMsg = new String(recvBuf); //byte�迭�� String���� ��ȯ�ϴ� �۾�
					System.out.println("������"+recvMsg+"��� ���մϴ�."); //�����°� ����ϱ�
					
					System.out.println("�������� ���� ���� ���� Enter");
					sendBuf = sc.nextLine(); // ������ ���� �޼���
					sender.write(sendBuf.getBytes());	//������ �޽��� ������
					//System.out.println("Ŭ���̾�Ʈ�� ���� �Ͻðڽ��ϱ�? (Y/N)");
					//sendBuf = sc.nextLine(); // ������ ���� �޼���
				} while (true); //sendBuf.equals("y")
				//System.out.println("Ŭ���̾�Ʈ ����");


				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			

		}

	}