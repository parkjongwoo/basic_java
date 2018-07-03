package com.day07.oop;

import java.util.Scanner;

public class Ex04_sugar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("설탕무게를 입력하세요.");
		System.out.println(getQuantity(sc.nextInt()));
		
		sc.close();
	}
	
	static int getQuantity(int sugarStock) {
		int ss = 0;//5kg봉지에 담을 총량을 제외한 남은 설탕량
		for(int i=sugarStock/5;i>=0;i--) {//총량/5가 5kg봉지에 담을 수 있는 최고치,0은 5kg봉지가 없을 경우
			ss = sugarStock - i * 5;//남은 량 산정
			if(ss % 3 == 0) //남은 량이 3kg단위로 딱맞게 떨어지면
				return i + ss / 3;//5kg봉지수 + 3kg봉지수 반환
		}		
		return -1;// 위에서 반환 안되면 소분 불가 -1반환
	}
}
