package com.Package.AccessModifier.fish;

import com.Package.AccessModifier.animal.cat;

public class tuna extends cat {

	public void tunaWeightPrint() {
		//tuna tunaFriend = new tuna(); //�̹� ��� �޾Ƽ�  SuperClass�� ���� �����ϱ� ��ü������ ���� �ʾƵ� ��� ���� �ϴ�.
		
		System.out.println(age1);
		System.out.println(age2);
//		System.out.println(tunaFriend.age3);
//		System.out.println(tunaFriend.age4);
		catAgePrint(); //cat�̶�� �̸��� superclass�� catAgePrint��� �޼ҵ带 ȣ�� �� �� �ִ�.
	}
}
