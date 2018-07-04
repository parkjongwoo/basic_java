package com.day11.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class HashSetLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);
		
		ArrayList<Integer> list = new ArrayList<Integer>(lotto);
		Collections.sort(list);
		
		System.out.println(list);
	}

}
