package com.Package.generic;


class Car<T>{ //객체생성 할때마다 자료형을 생성한다.
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
		//객체 생성할때 <자료형>을 선택 하여 같은 이름의 임의의 자료형에 다른자료형을 설정 할 수 있다.
		truck1.setDescription(100);
		truck1.carInfoPrint();
		
		Car<String> bungbung = new Car<String>();
		bungbung.setDescription("붕붕 자동차");
		bungbung.carInfoPrint();
		
		Car<Double> a = new Car();
		a.setDescription(123.456);
		a.carInfoPrint();
		
		
	}

}
