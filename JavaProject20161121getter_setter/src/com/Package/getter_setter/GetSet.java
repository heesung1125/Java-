package com.Package.getter_setter;
//강사님 소스 기준 cat1
public class GetSet {

	public int age1 = 3;
	protected int age2 = 4;
	/*default*/int age3 = 5; // 앞에 아무것도 없으면 default로 처리되며 강제 입력하면 에러처리 된다.
	private int age4 = 6;
	
	public void agePrint(){
		System.out.println(age1);
		System.out.println(age2);
		System.out.println(age3);
		System.out.println(age4);
	}
	/*
   	int age;	// 인스턴스 변수
	String name;	// 인스턴스 변수
	static int salary;	// 클래스 변수
	private String spices;
	static int catCount;// 클래스 변수
	int catCount2;// 클래스 변수
	final double pi = 3.14;
	
	public void test1() {
		System.out.println("public");
	}
	private void test2() {
		System.out.println("private");
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getSalary() {
		return salary;
	}
	public static void setSalary(int salary) {
		GetSet.salary = salary;
	}
	public String getSpices() {
		return spices;
	}
	public void setSpices(String spices) {
		this.spices = spices;
	}

	public static int getCatCount() {
		return catCount;
	}
	public static void setCatCount(int catCount) {
		GetSet.catCount = catCount;
	}
	public int getCatCount2() {
		return catCount2;
	}
	public void setCatCount2(int catCount2) {
		this.catCount2 = catCount2;
	}*/


}
