package com.Package.AccessModifier.animal;

public class animalHospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat cat1 = new cat(); // ��ü����
		cat1.catAgePrint(); // method ȣ��
		
		//cat.catAgePrint(); static method ����Ҷ��� ��ü ���� ���ϰ� ��� ����
		System.out.println(cat1.age1); //public
		System.out.println(cat1.age2); //protected
		System.out.println(cat1.age3); //default
		//System.out.println(cat1.age4); //private : �ܺ�Ŭ�������� ���� �Ұ���
	}

}
