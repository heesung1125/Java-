package com.Package.getter_setter;
//����� �ҽ� ���� dog1
public class MailClass {

	public static void main(String[] args) {
		
		GetSet2 gs222 = new GetSet2();
		
		System.out.println(gs222.age1);
		
		

		GetSet c1 = new GetSet();
		
		c1.agePrint();
		//c1.test2(); �޼ҵ忡 private�� �����ϸ� �ܺο��� ������� �� �Ѵ�.
		
		c1.agePrint();
		
		System.out.println("");
		System.out.println(c1.age1);
		System.out.println(c1.age2);
		System.out.println(c1.age3);
		//System.out.println(c1.age4); // ���� : private ����� Ŭ���� �ȿ����� ���Ǹ�, �ܺ� Ŭ���������� ��� �� �� ����.
		
/*		// static�� ����
		GetSet gs1 = new GetSet(); 	// ���� �� ��ü����1
		gs1.catCount = 5;			
		GetSet gs2 = new GetSet(); 	// ���� �� ��ü����2
		gs2.catCount = 6;

		// static�� ����
		GetSet gs11 = new GetSet();	// ���� �� ��ü����1
		gs11.catCount2 = 5;			// 
		GetSet gs22 = new GetSet();	// ���� �� ��ü����2
		gs22.catCount2 = 6;
		
		System.out.println(gs1.catCount);
		System.out.println(gs2.catCount);
		System.out.println("");		
		System.out.println(gs11.catCount);
		System.out.println(gs22.catCount);
		//���� Ŭ������ �ִ� �ɹ������� �ٸ��̸����� ��ü ���� �� ���� �ٸ� ���� �ָ�...
		// static�� �پ� ������ �� �������� �Է� �� gs2�� ���� ��� �ȴ�.
		// static�� �پ� ������ ���� �Էµ� ���� ��� �ȴ�.
		
		
//		System.out.println("Ŭ���� �ɹ������� ����Ͽ� ���� �����");
//		gs.age = 3;					//Direct Access
//		System.out.println(gs.age);
//
//		System.out.println("getter/setter�� ����Ͽ� �޼ҵ带 ���Ͽ� �����");
//		gs.setAge(4);					//Indirect Access
//		System.out.println(gs.getAge());
//		
//		System.out.println("private���� �� �ɹ����� �����");
//		//gs.spices = "mix"; private������ �Ǿ� �־ ��� �Ұ�
//		gs.setSpices("mix");
//		System.out.println(gs.getSpices());
		*/

	}
}
