package com.Package.generic;


class Car<T>{ //��ü���� �Ҷ����� �ڷ����� �����Ѵ�.
	private T description;
	public void carInfoPrint() {
		System.out.println(description);
		
	}
	public T getDescription() {
		return description;
	}
	public void setDescription(T description) {
		this.description = description;
	}
}


public class genericTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car<Integer> truck1 = new Car<Integer>();
		//��ü �����Ҷ� <�ڷ���>�� ���� �Ͽ� ���� �̸��� ������ �ڷ����� �ٸ��ڷ����� ���� �� �� �ִ�.
		truck1.setDescription(100);
		truck1.carInfoPrint();
		
		Car<String> bungbung = new Car<String>();
		bungbung.setDescription("�غ� �ڵ���");
		bungbung.carInfoPrint();
		
		Car<Double> a = new Car();
		a.setDescription(123.456);
		a.carInfoPrint();
		
		
	}

}
