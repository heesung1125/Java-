package com.Package.queue;

import java.util.LinkedList;
import java.util.Queue;

public class queueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> q1 = new LinkedList<String>();
		q1.offer("haha");
		q1.offer("hoho");
		q1.offer("hihi");
		q1.offer("huhu");
		
		System.out.println(q1);
		System.out.println(q1.poll()); //poll �迭�� ������ ���� �Ŀ��� �迭�ȿ��� ���� �ȴ�.
		
		System.out.println(q1);
		System.out.println(q1.poll());
		
		System.out.println(q1);
		System.out.println(q1.poll());
		
		System.out.println(q1);
		System.out.println(q1.poll());
		
		System.out.println(q1);
		System.out.println(q1.poll());
	}
}
