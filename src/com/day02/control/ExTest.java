package com.day02.control;

import java.util.Scanner;

public class ExTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("첫 번째 원하는 수를 입력하세요 >");
		int num1 = in.nextInt();
		System.out.println("두 번째 원하는 수를 입력하세요 >");
		int num2 = in.nextInt();
		System.out.println("세 번째 원하는 수를 입력하세요 >");
		int num3 = in.nextInt();

		if( num1> num2 && num1<num3 || num1<num2 && num1>num3)
		System.out.println(num1);
		else if(num2> num1 && num2 < num3 || num2< num1 && num2 > num3 ) 
		System.out.println(num2);
		else{ 
			System.out.println(num3);
		}
	}
}
