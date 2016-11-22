package com.Package.AccessModifier.fish;

import com.Package.AccessModifier.animal.cat;

public class tuna extends cat {

	public void tunaWeightPrint() {
		//tuna tunaFriend = new tuna(); //이미 상속 받아서  SuperClass의 것은 내꺼니까 객체생성을 하지 않아도 사용 가능 하다.
		
		System.out.println(age1);
		System.out.println(age2);
//		System.out.println(tunaFriend.age3);
//		System.out.println(tunaFriend.age4);
		catAgePrint(); //cat이라는 이름의 superclass의 catAgePrint라는 메소드를 호출 할 수 있다.
	}
}
