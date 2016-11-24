package com.Package.Multi_Thread;

public class RSP extends Thread {
	
	public void run() {
		for(int i=0;i < 20;i++){
			if(20%i == 0)System.out.println("가위\n");
			else System.out.println("바위\n");
			System.out.println("보\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
