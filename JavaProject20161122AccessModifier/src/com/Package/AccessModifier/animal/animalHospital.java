package com.Package.AccessModifier.animal;

public class animalHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat cat1 = new cat(); // ��ü����
//		cat1.catAgePrint1(); // method ȣ��
		
//		cat.catAgePrint(); static method ����Ҷ��� ��ü ���� ���ϰ� ��� ����
//		System.out.println(cat1.age1); //public : ��𼭳� ���� ����
//		System.out.println(cat1.age2); //protected : ���� Package �� ��ӹ��� Ŭ������ �ִٸ� ����
//		System.out.println(cat1.age3); //default : ���� Package �ȿ����� ���� ����
//		System.out.println(cat1.age4); //private : �ܺ�Ŭ�������� ���� �Ұ���
		
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
