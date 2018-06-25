package com.day02.operator;

public class Ex07_binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 15, b = 10;
//		a: 	00000000 00000000 00000000 00001111
//		b:	00000000 00000000 00000000 00001010
//		and:00000000 00000000 00000000 00001010	10
//		or:	00000000 00000000 00000000 00001111	15
//		xor:00000000 00000000 00000000 00000101	5
		int and = a&b;
		int or = a|b;
		int xor = a^b;
		
		System.out.println("and:"+and);
		System.out.println("or:"+or);
		System.out.println("xor:"+xor);
		
	}

}
