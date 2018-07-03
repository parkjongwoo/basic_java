package com.day10.ect;

class Parent{
	final String field = "부모님";
	final public void jib() {
		System.out.println("부모님 장만");
	}
}

class Child extends Parent{
	Child(){
//		field = "내꺼";//final 변경불가 컴파일 애러
	}
	
//	public void jib() {//final override 불가 컴파일 애러
//		System.out.println("탕진");
//	}
}
public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Child();
		p.jib();
	}

}
