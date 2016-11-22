package com.Package.AccessModifier.animal;

public class animalHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat cat1 = new cat(); // 객체생성
		cat1.catAgePrint(); // method 호출
		
		//cat.catAgePrint(); static method 사용할때는 객체 생성 안하고도 출력 가능
		System.out.println(cat1.age1); //public
		System.out.println(cat1.age2); //protected
		System.out.println(cat1.age3); //default
		//System.out.println(cat1.age4); //private : 외부클래스에서 접근 불가능
	}

}
