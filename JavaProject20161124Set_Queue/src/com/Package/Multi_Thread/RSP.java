package com.Package.Multi_Thread;

public class RSP extends Thread {
	
	public void run() {
		for(int i=0;i < 20;i++){
			if(20%i == 0)System.out.println("����\n");
			else System.out.println("����\n");
			System.out.println("��\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
