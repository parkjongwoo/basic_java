package com.day04.iteration2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex18_iteration4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Integer> data = new HashMap<Character, Integer>();
		
		data.put('A', 3);
		data.put('B', 3);
		data.put('C', 3);
		data.put('D', 4);
		data.put('E', 4);
		data.put('F', 4);
		data.put('G', 5);
		data.put('H', 5);
		data.put('I', 5);
		data.put('J', 6);
		data.put('K', 6);
		data.put('L', 6);
		data.put('M', 7);
		data.put('N', 7);
		data.put('O', 7);
		data.put('P', 8);
		data.put('Q', 8);
		data.put('R', 8);
		data.put('S', 8);
		data.put('T', 9);
		data.put('U', 9);
		data.put('V', 9);
		data.put('W', 10);
		data.put('X', 10);
		data.put('Y', 10);
		data.put('Z', 10);
		data.put('+', 11);
		data.put('-', 11);
		data.put('*', 11);
		data.put('/', 11);
		
		int elapseTime=0;//소요시간
		int len;//입력값 길이
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전화번호를 알파벳으로 입력하세요.");
		sb.append(sc.nextLine());
		
		len = sb.length();// 입력값 길이 계산
		for(int i=0;i<len;i++) {// 문자열 길이 만큼 반복
			
			if(data.get(sb.charAt(i))==null) {
				elapseTime +=2;
			}else {
				elapseTime += data.get(sb.charAt(i));
			}
		}
		System.out.println("다이얼 소요시간은 "+elapseTime+"초입니다.");
		
		sc.close();
	}

}
