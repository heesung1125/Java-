package com.Package.getter_setter;

public class GetSet {
	int age;
	String name;
	static int salary;
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

	
}
