package com.Package.Multi_Thread;

public class Avarta extends Thread{
	String name;
	
	public Avarta(String name){
		System.out.println("Thread Created!!");
		this.name = name;
	}
	
	public void run() {
		for(int count=0; count<30; count++){
			System.out.println(name + ": Attack" + count);
			try {
			      Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}
	}
}
