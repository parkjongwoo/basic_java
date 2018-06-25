package com.day02.operator;

import java.util.Scanner;

public class Ex05_Comparable {
	public static void main(String[] args) {
		// 비교 연산자: 두값을 비교하여 결과를 boolean 값으로 반환하는 연산자 
		// >,<,>=,<=,!=,==
		// a > b : a가 b "초과"이면 true, a가 b "이하" 이면 false.
		// a >= b : a가 b "이상"이면 true, a가 b"미만" 이면 false.
		// a == b : a와 b가 같으면 true, 다르면 false.
		// a != b : a와 b가 다르면 true, 같으면 false.
		
		Scanner in = new Scanner(System.in);

		System.out.println("이름입력->");
		String name = in.nextLine();

		System.out.println("국어점수->");
		int kor = in.nextInt();

		System.out.println("영어점수->");
		int eng = in.nextInt();

		System.out.println("수학점수->");
		int mat = in.nextInt();

		int tot = kor + eng + mat;
		double mean = (double) (tot / 3);

		System.out.println("이름:" + name);
		System.out.println("국어점수:" + kor);
		System.out.println("영어점수:" + eng);
		System.out.println("수학점수:" + mat);

		System.out.println("합계:" + tot);
		System.out.println("평균:" + mean);
		
		if(mean>=90) {
			System.out.println("학점:A");
		}else if(mean>=80) {
			System.out.println("학점:B");
		}else {
			System.out.println("학점:C");
		}
		
		in.close();
	}
}
