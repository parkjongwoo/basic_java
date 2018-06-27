package com.day06.method;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex07_method_q3 {
	// 완성하세요.
		
	public static void main(String[] args) {
		
		char[][] chars = input();
		output(chars);
	}

	static void output(char[][] chars) {
		// 문자 배열에 저장된 문자들을 화면에 출력한다.
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<chars.length;i++) {//행수 반복
			for(int j=0;j<chars[i].length;j++) {//열수 반복
				sb.append(chars[i][j]);//출력에 저장
			}
			sb.append('\n');//출력 줄바꿈
		}
		System.out.println(sb);// 출력
	}

	static char[][] input() {
		// 두 정수와 알파벳 문자 하나를 입력받는다
		// [예] 3 4 F
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수와 알파벳 문자 한글자를 입력하세요.");
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		sc.close();

		char[][] chars = makeSquare(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));//1 정수, 2 정수, 3 문자 순서로 입력받음
		
		return chars;
	}

	static char[][] makeSquare(int col, int row, char c) {
		// 입력받은 첫 번째 정수만큼의 행과 두번째 정수만큼의 문자 배열을 만들어
		// 입력받은 문자를 시작으로 저장한다.
		/*
		 * F G H I J K L M N O P Q
		 */
		char[][] chars = new char[col][row];//행,열 크기로 메모리 생성
		
		for(int i=0;i<col;i++) {//행 크기 반복
			for(int j=0;j<row;j++) {//열 크기 반복
				chars[i][j] = c;//정수형 문자 코드를 문자로 변환하여 저장
				c++;//다음 코드
			}
		}
		return chars;
	}

}
