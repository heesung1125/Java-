package com.Package.getter_setter;

public class MailClass {

	public static void main(String[] args) {
		GetSet gs = new GetSet();
		
		System.out.println("Ŭ���� �ɹ������� ����Ͽ� ���� �����");
		gs.age = 3;
		System.out.println(gs.age);

		System.out.println("");
		System.out.println("getter/setter�� ����Ͽ� �����");
		gs.setAge(4);
		System.out.println(gs.getAge());

	}

}
