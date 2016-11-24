package com.Package.Iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class IteratorTest {

	public static void Collections(int num, int num1) {
		
		switch (num) {
		case 1: // HashSet
			System.out.println("OK HashSet");
			HashSet<Integer> hs1 = new HashSet<Integer>();
			for(int i=0; i < num1;i++)	hs1.add(i);
			Iterator<Integer> i_hs1 = (Iterator)hs1.iterator();
			while(i_hs1.hasNext()) System.out.println(i_hs1.next());

			break;
			
		case 2: // ArrayList
			System.out.println("OK ArrayList");
			ArrayList<Integer> al1 = new ArrayList<Integer>();
			for(int i=0; i < num1;i++) 	al1.add(i);
			Iterator<Integer> i_al1 = (Iterator)al1.iterator();
			while(i_al1.hasNext()) System.out.println(i_al1.next());
			break;
			
		case 3: //Queue
			System.out.println("OK Queue(LinkdeList)");
			Queue<Integer> q1 = new LinkedList<Integer>();
			for(int i=0; i < num1; i++) q1.offer(i);
			Iterator<Integer> i_q1 = (Iterator)q1.iterator();
			while(i_q1.hasNext()) System.out.println(i_q1.next());
			break;

			
		default:
			break;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int type;
		int number;
		
		System.out.println("Collection Type : 1.HashSet, 2.ArrayList, 3.Queue(LinkdeList)");
		type = scan.nextInt();
		System.out.println("생성하고 싶은 배열 숫자.");
		number = scan.nextInt();
		
		Collections(type,number);
		
/*		HashSet<Integer> hs1 = new HashSet<Integer>();
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		hs1.add(5);
		hs1.add(3);
		hs1.add(1);
		
		System.out.println(hs1.toString());

		System.out.println("");
		System.out.println("HashList__Iterator");
		Iterator i_hs1 = (Iterator)hs1.iterator();
		while (i_hs1.hasNext()) {
			System.out.println(i_hs1.next());
			}
		System.out.println("");
		
		ArrayList<Integer> arrayList1;
		arrayList1 = new ArrayList<Integer>();
		arrayList1.add(10);
		arrayList1.add(20);
		arrayList1.add(30);
		arrayList1.add(40);
		arrayList1.add(50);

//		for(int i=0; i < arrayList1.size();i++){
//			System.out.println(arrayList1.get(i));
//			}
		System.out.println("ArrayList__Iterator");
		Iterator i_al1 = (Iterator)arrayList1.iterator();
		while (i_al1.hasNext()) {
			// .hasNext() : 읽어 올 요소가 남아있는지 확인하는 메소드이다. 있으면 true, 없으면 false를 반환.
			System.out.println(i_al1.next());
			// .next() : iteration의 다음 객체를 리턴.
			}
		System.out.println("");
		
		Queue<String> q1 = new LinkedList<String>();
		q1.offer("haha");
		q1.offer("hoho");
		q1.offer("hihi");
		q1.offer("huhu");
		
		System.out.println("Queue_Iterator");
		Iterator i_q1 = (Iterator)q1.iterator();
		while (i_q1.hasNext()) {
			// .hasNext() : 읽어 올 요소가 남아있는지 확인하는 메소드이다. 있으면 true, 없으면 false를 반환.
			System.out.println(i_q1.next());
			// .next() : iteration의 다음 객체를 리턴.
			}*/
	}
}
