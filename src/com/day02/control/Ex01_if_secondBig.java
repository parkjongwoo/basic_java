package com.day02.control;

import java.util.Scanner;

public class Ex01_if_secondBig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		int c;
		System.out.println("비교할 세 수를 입력하세요.");
			
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		double mean = (a+b+c);
		String mid;
		if(a<b) {
//			a<b
			if(b<c) {
//				a<b<c
				mid = "b";
			}else {
//				a c<=b
				if(a<c) {
//					a < c <=b
					if(b == c) {
						mid = "bc";
					}else {
						mid = "c";
					}
				}else if(a==c){
//					c <= a < b
					mid = "ac";
				}else {
					mid = "a";
				}
			}
		}else {
			//b<=a
			if(c<b) {
//				c<b<=a
				
				if(b == a) {
					mid = "ab";
				}else {
					mid = "b";
				}
			}else {
//				b<=a c
				if(c<a) {
//					b<=c<a
					
					if(b==c) {
						mid = "cb";
					}else {
						mid = "c";
					}
				}else {
//					b<=a<=c
					if(a == b && b == c) {
						mid = "abc";
					}else if(a==c) {
						mid = "ac";
					}else if(a==b) {
						mid = "ab";
					}else {
						mid = "a";						
					}
				}
			}
		}
		System.out.println("중앙값:"+mid);
		sc.close();
	}

}
