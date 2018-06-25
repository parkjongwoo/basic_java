package com.day02.operator;

import java.util.Scanner;

public class Ex03_arithmeticOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// +,-,/,* 더하기,빼기,나누기,곱하기
		// % 나머지연산: 나머지를 구한다. 반복되는 수열에서 패턴을 만들기 위해 자주 사용된다.
		// +=,-=,*=,/= 축약 가능. ex01참고
		
		// 정수를 입력받아 짝수, 홀수 인지 출력해보자.
		
		Scanner sc = new Scanner(System.in);
		int input=0;
		
		System.out.println("정수를 입력하세요.");
		input = sc.nextInt();
		
		if(input%2==0) {
			System.out.println(input+" 값은 짝수 입니다.");
		}else {
			System.out.println(input+" 값은 홀수 입니다.");
		}
		
		sc.close();
	}

}
