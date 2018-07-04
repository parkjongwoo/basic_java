package com.day11.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(4);
		list.add("rabbit");
		list.add("mouse");
		list.add("cat");
		list.add("dog");
		list.add("fox");
		list.add("lion");
		
		Collections.sort(list);
		System.out.println(list);
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
//				
//		for(String s:list) {
//			System.out.println(s);
//		}		
	}
}
