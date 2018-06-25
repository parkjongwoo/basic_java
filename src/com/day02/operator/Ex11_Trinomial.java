package com.day02.operator;

import java.util.Scanner;

public class Ex11_Trinomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두 수 입력 큰 수 출력
		
		Scanner sc = new Scanner(System.in);
		int first;
		int second;
		
		System.out.println("첫 번째 값 입력하세요.");
		
		first = sc.nextInt();
		System.out.println("두 번째 값 입력하세요.");
		
		second = sc.nextInt();
		
		System.out.print(first>second?first:second);
		System.out.println(" 값이 큽니다.");
		
		sc.close();
	}

}
