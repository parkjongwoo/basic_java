package com.day07.oop;

import java.util.Scanner;

public class Ex04_sugar {

	public static void main(String[] args) {
		SugarFactory sf = new SugarFactory();
		Scanner sc = new Scanner(System.in);
		System.out.println("설탕무게를 입력하세요.");
		sf.setSugarStock(sc.nextInt());
		
		System.out.println(sf.getQuantity());
		
		sc.close();
	}

}
