package com.day01.data;

import java.util.Scanner;

public class Ex07_Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("이름입력->");
		String name = in.nextLine();
		
		System.out.println("국어점수->");		
		int kor = in.nextInt();
		
		System.out.println("영어점수->");		
		int eng = in.nextInt();
		
		System.out.println("수학어점수->");		
		int mat = in.nextInt();
		
		int tot = kor + eng + mat;
		double mean = (double)(tot / 3);	
		
		System.out.println("이름:"+name);
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+mat);
		
		System.out.println("합계:"+tot);
		System.out.println("평균:"+mean);
		
		in.close();
		
			
		
	}

}
