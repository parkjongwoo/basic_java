package com.day04.iteration2;

import java.util.Scanner;

public class Ex17_iteration3 {

	public static void main(String[] args) {
		int elapseTime=0;//소요시간
		int len;//입력값 길이
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전화번호를 알파벳으로 입력하세요.");
		sb.append(sc.nextLine());
		
		len = sb.length();// 입력값 길이 계산
		for(int i=0;i<len;i++) {// 문자열 길이 만큼 반복
			switch(sb.charAt(i)) {// 문자 소요시간 만큼 시간 추가
			case 'A':
			case 'B':
			case 'C':
				elapseTime+=3;
				break;
			case 'D':
			case 'E':
			case 'F':
				elapseTime+=4;
				break;
			case 'G':
			case 'H':
			case 'I':
				elapseTime+=5;
				break;
			case 'J':
			case 'K':
			case 'L':
				elapseTime+=6;
				break;
			case 'M':
			case 'N':
			case 'O':
				elapseTime+=7;
				break;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				elapseTime+=8;
				break;
			case 'T':
			case 'U':
			case 'V':
				elapseTime+=9;
				break;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				elapseTime+=10;
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				elapseTime+=11;
				break;
			default:
				elapseTime+=2;
				break;
			}
		}
		
		System.out.println("다이얼 소요시간은 "+elapseTime+"초입니다.");
		
		sc.close();
	}

}
