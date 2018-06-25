package com.day01.data;

public class Ex05_String_noNew {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String a = "홍길동";
		String b = "홍길동";
		
		char[] strs = {'a','b','c','d'};
		char[] strs2 = {'a','b','c','d'};
		
		
		if(a==b) 
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		if(a.equals(b)) 
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		if(strs == strs2)
			System.out.println("같다");
		else
			System.out.println("다르다");
	}

}
