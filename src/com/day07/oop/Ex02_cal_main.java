package com.day07.oop;

import java.util.Scanner;

public class Ex02_cal_main {

	public static void main(String[] args) {
		calculatorExpr ce = new calculatorExpr();
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		do {
			System.out.println("숫자 두 개를 입력하세요.");
			
			ce.setNum1(sc.nextInt());
			ce.setNum2(sc.nextInt());
			
			sb.append("추출된 숫자: ").append(ce.getNum1()).
			append(',').append(ce.getNum2()).append('\n');
				
			
			sb.append("덧셈: ").append(ce.getAddition()).append('\n').
			append("뺄셈: ").append(ce.getSubtraction()).append('\n').
			append("곱셈: ").append(ce.getMultiplication()).append('\n').
			append("나눗셈: ").append(ce.getDivision()).append('\n');
			
			System.out.println(sb);
			sb.setLength(0);			
			sc.nextLine();
			
			System.out.println("계속 진행합니까?(y/n)");
					
		}while(sc.nextLine().charAt(0)=='y');
		
		sc.close();
	}

}
