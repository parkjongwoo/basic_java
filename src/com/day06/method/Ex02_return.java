package com.day06.method;

public class Ex02_return {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = method();
		System.out.println("kor:"+scores[0]+" eng:"+scores[1]+" math:"+scores[2]);
	}
	
	static int[] method() {
		int kor=30,eng=88,math=40;
		
		return new int[] {kor,eng,math};
	}
}
