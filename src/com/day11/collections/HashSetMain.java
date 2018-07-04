package com.day11.collections;

import java.util.HashSet;

public class HashSetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("rabbit");
		set.add("mouse");
		set.add("cat");
		set.add("dog");
		set.add("fox");
		set.add("lion");
		set.add("fox");
		set.add("fox");
		
		System.out.println(set);
	}

}
