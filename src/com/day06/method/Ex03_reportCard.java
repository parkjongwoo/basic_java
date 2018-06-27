package com.day06.method;

import java.util.Scanner;

public class Ex03_reportCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = new int[3];
		
		input(scores);
		output(getTotal(scores),getAve(scores));
	}
	
	/**
	 * 국영수 점수를 입력
	 * @param scores 국영수점수를 저장할 배열
	 */
	static void input(int[] scores) {
		Scanner sc = new Scanner(System.in);
		System.out.println("국영수 점수를 입력하세요.");
		for(int i=0;i<scores.length;i++) {
			scores[i] = sc.nextInt();
		}
		sc.close();
	}
	
	/**
	 * 입력받은 점수들을 총점구하기
	 * @param scores 국영수점수를 저장하고 있는 배열
	 */
	static int getTotal(int[] scores) {
		int tot=0;
		for(int i=0;i<scores.length;i++) {
			tot += scores[i];
		}
		return tot;
 	}
	
	/**
	 * 점수들의 총점에 평균 구하기
	 * @param scores 국영수점수를 저장하고 있는 배열
	 */
	static double getAve(int[] scores) {
		return (double)getTotal(scores)/scores.length;
	}
	
	/**
	 * 총점과 평균 출력
	 * @param tot 총점
	 * @param avg 평균
	 */
	static void output(int tot, double avg) {
		System.out.println("총점: "+ tot + " 평균: "+ avg);
	}
}
