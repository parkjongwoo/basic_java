package com.day01.data;

public class Ex02_DataType {
	public static void main(String[] args) {
		
		
		
		// 기본데이터형 primitive type
		//
		
		// 부울 타입,true:false 두가지 값만 존재. 크기는 
		boolean bool = true;
		
		byte b = 36;
		// 문자형, 부호불포함, 메모리 크기: 2Byte
		// 문자의 ASCII코드값을 저장한다.
		char ch = 'A';
		System.out.println(ch);

		// 정수형, 부호포함, 메모리 크기: 4Byte, 표현범위: -2^31 ~ 2^31-1 >>
		// 2^(4Byte*8bit)의 표현가능 == 2^32.
		// 첫 1bit는 부호표시로 쓰이므로 값의 범위는 2^31
		int n = 'A';// 문자는 ASCII코드값을 표현하므로 이런 방식도 가능
		System.out.println(n);

		int n2 = 100;
		System.out.println(n2);

		// 정수형, 부호포함, 메모리 크기: 8Byte, 표현범위: -2^63 ~ 2^63-1 >>
		// 2^(8Byte*8bit)의 표현가능 == 2^64.
		// 첫 1bit는 부호표시로 쓰이므로 값의 범위는 2^63
		long n3 = 100000000000000000l;
		System.out.println(n3);
		
		// 실수형, 부호포함,메모리 크기: 4Byte, 표현범위: 
		float f = 100f; 
		System.out.println(f);

		float f2 = 100.01f;
		System.out.println(f2);
		
		// 실수형, 부호포함,메모리 크기: 8Byte, 표현범위:
		double d = 100d;
		System.out.println(d);

		double d2 = 100.0000000011111222d;
		System.out.println(d2);

		

		int i = (int) b;

		System.out.println("b = " + b);

		System.out.println("i = " + i);

		byte a = 64;

		byte c = 64;

		byte result = (byte) (a + c);

		System.out.println("result = " + result);

		byte b5 = 36;

		int i5 = b5;

		System.out.println("b = " + b5);

		// System.out.println("i = " + typeof(i5);

		int k = 360;

		byte b2 = (byte) k;

		System.out.println("k = " + k);

		System.out.println("b2 = " + b2);

		byte b3 = 127;

		char ch3 = '글';

		int i3 = 20000000;

		long l3 = 1L;

		b3 = (byte) i3;
		i3 = ch3;
		int var = b3;
		float f3 = l3;
		l3 = i3;

		System.out.printf("%d %d %d %f %d", b3, i3, var, f3, l3);

		// double d = 12345678.0;
	}
}
