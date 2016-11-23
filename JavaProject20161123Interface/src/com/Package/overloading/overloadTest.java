package com.Package.overloading;

public class overloadTest {
	
	public void overMethod() {
		System.out.println("overMethod");
	}
	
	public void overMethod(int num) {
		System.out.println("overMethod " + num);
	}
	
	public void overMethod(String name) {
		System.out.println("overMethod " + name);
	}
	
	public void overMethod(int num, String name) {
		System.out.println("overMethod " + num + " & " + name);
	}
	

}
