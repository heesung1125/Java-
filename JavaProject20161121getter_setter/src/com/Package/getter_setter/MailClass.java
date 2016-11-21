package com.Package.getter_setter;

public class MailClass {

	public static void main(String[] args) {
		GetSet gs = new GetSet();
		
		System.out.println("클래스 맴버변수명 사용하여 직접 입출력");
		gs.age = 3;
		System.out.println(gs.age);

		System.out.println("");
		System.out.println("getter/setter를 사용하여 입출력");
		gs.setAge(4);
		System.out.println(gs.getAge());

	}

}
