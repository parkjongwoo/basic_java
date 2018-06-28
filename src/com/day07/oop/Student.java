package com.day07.oop;

class Student {
	
	private String name;
	private int kor,eng,math;
	private int total;
	private double avg;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}	
	
	int calTotal() {
		total = kor+eng+math;
		return total;
	}
	double calAverage() {
		avg = (double)total/3;
		return avg;
	}
}
