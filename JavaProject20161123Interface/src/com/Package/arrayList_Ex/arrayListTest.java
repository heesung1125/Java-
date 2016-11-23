package com.Package.arrayList_Ex;

import java.util.ArrayList;
import java.util.Scanner;

public class arrayListTest {
	Scanner sc = new Scanner(System.in);
	
	private static ArrayList<Integer> arrayList1;
	Integer[] array1 = {1,2,3,4,5};
	
	
	public void run1() {
		arrayList1 = new ArrayList<Integer>();
		arrayList1.add(1);
		arrayList1.add(2);
		arrayList1.add(3);
		arrayList1.add(4);
		arrayList1.add(5);

//		System.out.println("array");
//		System.out.println(array1[0]);
//		System.out.println(array1[1]);
//		System.out.println(array1[2]);
//		System.out.println(array1[3]);
//		System.out.println(array1[4]);
//		
//		System.out.println("\narrayList1");
//		System.out.println(arrayList1.get(0));
//		System.out.println(arrayList1.get(1));
//		System.out.println(arrayList1.get(2));
//		System.out.println(arrayList1.get(3));
//		System.out.println(arrayList1.get(4));
//		arrayList1.add(6);
//		System.out.println(arrayList1.get(5));		
//		System.out.println("arraylist size : " + arrayList1.size());//arraylist 배열 사이즈 크기 확인		
//		System.out.println(arrayList1.remove(3));
		
		arraylist1();
		arrayList1.add(6); //배열 추가
		arraylist1();
		arrayList1.remove(3); //해당 주소값 배열 삭제
		arraylist1();
		arrayList1.clear(); // 배열 전체 삭제
		arraylist1();
		
	}
	
	public void arraylist1() {
		System.out.println("\narrayList1");
		for(int i=0; i < arrayList1.size();i++){
			System.out.println(arrayList1.get(i));
		}
		System.out.println("arraylist size : " + arrayList1.size());
	}
	
}
