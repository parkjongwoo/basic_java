package com.day03.iteration;

public class Ex01_for_q1 {

	public static void main(String[] args) {
//		문제 1)1~ N까지의 숫자를 다음처럼 출력하라
//
//		1 2 3 4 5 
//		6 7 8 9 10
//		11 12 13 14 15
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=15;i++) {
			sb.append(i).append(' ');
			if(i%5==0)
				sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
