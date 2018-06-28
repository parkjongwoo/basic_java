package com.day07.oop;
public class Ex01_basic_main {

	public static void main(String[] args) {
		Student s;
		s = new Student();
		s.setName("홍길동");
		s.setKor(88);
		s.setEng(90);
		s.setMath(70);
		System.out.println(s.getName()+"님 총점: "+s.calTotal());
		System.out.println(s.getName()+"님 평균: "+s.calAverage());
	}

}
