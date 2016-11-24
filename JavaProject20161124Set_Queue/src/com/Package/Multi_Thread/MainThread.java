package com.Package.Multi_Thread;

public class MainThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avarta park = new Avarta("SSyang!!");
//		Avarta choi = new Avarta("youdie!!");
		RSP rsp = new RSP();

		park.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		choi.start();
		
		rsp.start();
	}

}
