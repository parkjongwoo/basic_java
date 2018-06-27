package com.day06.method;

public class Ex05_overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "홍길순";
		StringBuffer sb = new StringBuffer("홍길자");
		char[] ch = new char[] {'홍','길','동'};
		fighting(str);
		fighting(sb);
		fighting(ch);
	}
	
	static void fighting(char[] a) {
		System.out.println(String.valueOf(a)+"파이팅!");
	}
	
	static void fighting(StringBuffer a) {
		System.out.println(a+"파이팅!");
	}
	
	static void fighting(String a) {
		System.out.println(a+"파이팅!");
	}
}
