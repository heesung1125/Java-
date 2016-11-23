package com.Package.overloading;

public class overLoadRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		overloadTest over1 = new overloadTest();
		
		over1.overMethod();
		over1.overMethod(10);
		over1.overMethod("babo");
		over1.overMethod(10,"babo");
	}

}
