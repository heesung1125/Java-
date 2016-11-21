package com.Package.getter_setter;
//강사님 소스 기준 dog1
public class MailClass {

	public static void main(String[] args) {
		
		GetSet2 gs222 = new GetSet2();
		
		System.out.println(gs222.age1);
		
		

		GetSet c1 = new GetSet();
		
		c1.agePrint();
		//c1.test2(); 메소드에 private를 설정하면 외부에서 사용하지 못 한다.
		
		c1.agePrint();
		
		System.out.println("");
		System.out.println(c1.age1);
		System.out.println(c1.age2);
		System.out.println(c1.age3);
		//System.out.println(c1.age4); // 에러 : private 선언된 클래스 안에서만 사용되며, 외부 클래스에서는 사용 할 수 없다.
		
/*		// static가 있음
		GetSet gs1 = new GetSet(); 	// 변수 및 객체생성1
		gs1.catCount = 5;			
		GetSet gs2 = new GetSet(); 	// 변수 및 객체생성2
		gs2.catCount = 6;

		// static가 없음
		GetSet gs11 = new GetSet();	// 변수 및 객체생성1
		gs11.catCount2 = 5;			// 
		GetSet gs22 = new GetSet();	// 변수 및 객체생성2
		gs22.catCount2 = 6;
		
		System.out.println(gs1.catCount);
		System.out.println(gs2.catCount);
		System.out.println("");		
		System.out.println(gs11.catCount);
		System.out.println(gs22.catCount);
		//같은 클래스에 있는 맴버변수에 다릉이름으로 객체 생성 후 서로 다른 값을 주면...
		// static가 붙어 있으면 맨 마지막에 입력 된 gs2의 값만 출력 된다.
		// static가 붙어 있으면 각자 입력된 값이 출력 된다.
		
		
//		System.out.println("클래스 맴버변수명 사용하여 직접 입출력");
//		gs.age = 3;					//Direct Access
//		System.out.println(gs.age);
//
//		System.out.println("getter/setter를 사용하여 메소드를 통하여 입출력");
//		gs.setAge(4);					//Indirect Access
//		System.out.println(gs.getAge());
//		
//		System.out.println("private설정 한 맴버변수 입출력");
//		//gs.spices = "mix"; private설정이 되어 있어서 출력 불가
//		gs.setSpices("mix");
//		System.out.println(gs.getSpices());
		*/

	}
}
