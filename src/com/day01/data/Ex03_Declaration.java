package com.day01.data;

public class Ex03_Declaration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor = 80;
		int eng = 60;
		int temp;
		if(kor == eng) {
			System.out.println("값이 같다.");
		}else {
			System.out.println("값이 다르다");
		}
		
		System.out.println("국어:"+kor+", 영어:"+eng);
		
		//두 점수 바꾸기
		temp = kor;
		kor = eng;
		eng = temp;
		
		System.out.println("국어:"+kor+", 영어:"+eng);
	}

}
