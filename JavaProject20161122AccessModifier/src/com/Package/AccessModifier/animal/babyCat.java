package com.Package.AccessModifier.animal;

import org.omg.CORBA.PUBLIC_MEMBER;

public class babyCat extends cat {
	int babyAge = age1;
	
	public void babyCatAgePrint() {
		catAgePrint1();
		
	}

@Override
public void catAgePrint1() {
	// catAgePrint1() 메소드를 상속 거부하겠다.
	System.out.println(age1*12+"개월");
	System.out.println(age2*12+"개월");
	System.out.println(age3*12+"개월");
//	System.out.println(age4*12+"개월");
//	super.catAgePrint1();
}


//	public void catAgePrint2() {
//		
//		System.out.println(age1);
//		System.out.println(age2);
//		System.out.println(age3);
//		//System.out.println(age4);
//	}


}
