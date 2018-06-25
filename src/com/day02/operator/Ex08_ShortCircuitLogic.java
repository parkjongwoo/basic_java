package com.day02.operator;

public class Ex08_ShortCircuitLogic {

	public static void main(String[] args) {
		int a = 3;
		if( a>3 && ++a>3) {
			System.out.println("조건만족-1");//출력안됨
		}
		System.out.println("a= "+a);//3
		
		if( a>1 || ++a>3) {
			System.out.println("조건만족-2");//출력됨
		}
		System.out.println("a= "+a);//3
		
		
		a = 3;
		if( a>3 & ++a>3) {
			System.out.println("조건만족-3");//출력안됨
		}
		System.out.println("a= "+a);//4
		
		if( a>1 | ++a>3) {
			System.out.println("조건만족-4");//출력됨
		}
		System.out.println("a= "+a);//5
		
		System.out.println("345983459874 | 14375943759 = "+(345983459874L | 14375943759L));
		System.out.println("a | b = "+('a' | 'b'));
		System.out.println(Integer.toBinaryString('a'));
		System.out.println(Integer.toBinaryString('b'));
		System.out.println(Integer.toBinaryString(('a' | 'b')));
	}

}
