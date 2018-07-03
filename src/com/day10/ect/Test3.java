package com.day10.ect;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("100", "홍길자");
		Student s2 = new Student("100", "홍길자");
		
		if(s1 == s2)
			System.out.println("1.같다");
		else
			System.out.println("1.다르다");
		
		if(s1.equals(s2))
			System.out.println("2.같다");
		else
			System.out.println("2.다르다");
		
	}

}
