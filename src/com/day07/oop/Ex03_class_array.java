package com.day07.oop;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex03_class_array {

	public static void main(String[] args) {
		Student[] s = new Student[3];
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<s.length;i++) {
			s[i]=new Student();
			// 각 학생의 이름과 점수를 입력받아 총점과 평균 구하기
			System.out.println("학생"+(i+1)+"의 이름/국/영/수 점수를 입력하세요.");
			st = new StringTokenizer(sc.nextLine());
			s[i].setName(st.nextToken());
			s[i].setKor(Integer.parseInt(st.nextToken()));
			s[i].setEng(Integer.parseInt(st.nextToken()));
			s[i].setMath(Integer.parseInt(st.nextToken()));
			
			
			sb.append("학생").append(s[i].getName()).append("의 점수는\n").
			append("총점: ").append(s[i].calTotal()).append('\n').
			append("평균: ").append(s[i].calAverage()).append('\n');
		}
		
		System.out.println(sb);
		
		sc.close();
	}

}
