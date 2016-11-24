package com.Package.HashSet;

import java.util.HashSet;
import java.util.*;

public class hashSetTest {
	public static void main(String[] args) {
		HashSet<Integer> hs1 = new HashSet<Integer>();
		
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		hs1.add(5);
		hs1.add(3);
		hs1.add(1000);
		hs1.add(48500);
		hs1.add(10541300);
		hs1.add(1020);
		
		
		System.out.println(hs1.toString());

		Iterator i_hs1 = (Iterator)hs1.iterator();
		while (i_hs1.hasNext()) {
			System.out.println(i_hs1.next());
			
		// 중복값은 자동 검사해서 입력하지 않는다.
		}
	}
}
