package com.day02.operator;

public class Ex01_IncDec {
	public static void main(String[] args) {
		
//		연산자 순위
		
//		1.최우선
//		. [] ()

//		2.단항 연산자
//		+-, ++,--,!,~,(int)
		
//		3.산술(우선,차선)
//		*,/,% 	+,-,
		
//		4.시프트
//		<< >> >>>
//		
//		5.관계
//		> < <= >= == !=
//		
//		6.비트
//		& ^ |
//		
//		7.논리
//		&& ||
//		
//		8.삼항
//		조건(boolean)?반환값1:반환값2
		
		
		
		int a=7,b=3;
				
		//후위 연산자: 연산자가 다른 연산자의 내부에 사용되었을 경우
		//외부 연산 처리를 먼저 하고 증감처리를 한다
		a++;
		b++;
		System.out.println("A="+a+", B="+b);
		//a==9,b==3
		
		//전위 연산자: 연산자가 다른 연산자의 내부에 사용되었을 경우
		//먼저 증감처리를 하고 외부연산을 진행한다.
		--a;
		--b;
		System.out.println("A="+a+", B="+b);
		//a==8,b==2
		
		// a==8 에서 먼저 ++처리되고 result1에 할당. 그러므로 result1은 9
		int result1 = ++a;
		System.out.println("result1="+result1);
		//result1 = 9
		
		// a==9에서 먼저 result2에 할당되고 ++처리. 그러므로 result2는 9 a==10
		int result2 = a++;
		System.out.println("result2="+result2);
		//result2 = 9
		System.out.println("A="+a);
		//a=10
	}
}
