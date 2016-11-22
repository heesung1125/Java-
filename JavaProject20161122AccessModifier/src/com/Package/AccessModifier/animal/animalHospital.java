package com.Package.AccessModifier.animal;

public class animalHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat cat1 = new cat(); // 객체생성
//		cat1.catAgePrint1(); // method 호출
		
//		cat.catAgePrint(); static method 사용할때는 객체 생성 안하고도 출력 가능
//		System.out.println(cat1.age1); //public : 어디서나 접근 가능
//		System.out.println(cat1.age2); //protected : 같은 Package 및 상속받은 클래스가 있다면 가능
//		System.out.println(cat1.age3); //default : 같은 Package 안에서만 접근 가능
//		System.out.println(cat1.age4); //private : 외부클래스에서 접근 불가능
		
//		cat cat2 = new cat();
//		cat2.catAgePrint1();//public
//		cat2.catAgePrint2();//protected
//		cat2.catAgePrint3();//default
//		cat2.catAgePrint4();//private
		
		cat adult_cat1 = new cat();
		adult_cat1.catAgePrint1();
		
		babyCat baby_cat1 = new babyCat();
		baby_cat1.catAgePrint1();
		
	}

}
