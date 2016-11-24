package com.Package.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> fruitPrice = new HashMap<String,Integer>();
		fruitPrice.put("apple", 1500);
		fruitPrice.put("banana", 900);
		fruitPrice.put("lemon", 2000);
		fruitPrice.put("orange", 1300);
		
		//System.out.println(fruitPrice);
		
		System.out.println(fruitPrice.get("lemon")); // lemon °ª Ãâ·Â
		System.out.println(fruitPrice.entrySet());
		
		Set entrySet = fruitPrice.entrySet();
		
		Iterator i_entey = entrySet.iterator();
		while(i_entey.hasNext()) System.out.println(i_entey.next());
		
		Set keySet = fruitPrice.keySet();
		Iterator i_key = keySet.iterator();
		while(i_key.hasNext()) System.out.println(i_key.next());
		
		


	}

}
