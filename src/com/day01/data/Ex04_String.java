package com.day01.data;

public class Ex04_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = new String("홍길동");
		String b = new String("홍길동");
		String c;
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
		
		c = a;
		if(a==c) 
			System.out.println("a==c:같다");
		else
			System.out.println("a==c:다르다");
		a = a.concat("전");
		System.out.println(a);
		System.out.println(c);
		if(a==c) 
			System.out.println("a==c:같다");
		else
			System.out.println("a==c:다르다");
		
//		StringBuffer a = new StringBuffer("홍길동");
//		StringBuffer b = new StringBuffer("홍길동");
//		
//		if (a == b)
//			System.out.println("같다");
//		else
//			System.out.println("다르다");
//		
//		if (a.equals(b))
//			System.out.println("같다");
//		else
//			System.out.println("다르다");
	}

}
