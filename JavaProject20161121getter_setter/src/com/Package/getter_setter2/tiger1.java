package com.Package.getter_setter2;

import com.Package.getter_setter.GetSet;

public class tiger1 {
	public static void main(String[] args) {
		GetSet tiger = new GetSet();
		
		//tiger.agePrint();
		
		System.out.println(tiger.age1); // 패키지 외부에서는 public만 사용 가능
		//System.out.println(tiger.age2);
		//System.out.println(tiger.age3);
		//System.out.println(tiger.age4);
	}
}
