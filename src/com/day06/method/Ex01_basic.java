package com.day06.method;

public class Ex01_basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3,b=8;
		add(a,b);
		add2();
		System.out.println("x+y:"+add2());
	}
	static int add(int a, int b) {
		return a+b;
	}
	
	static int add2() {
		int x= 8,y=2;
		return x+y;
	}
}
