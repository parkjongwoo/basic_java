package com.day10.ect;

public class Test2 {

	public static void main(String[] args) {
		Object[] data = method();
		for(int i=0;i<data.length;i++)
			System.out.println(data[i]);
		
	}
	
	static Object[] method() {
		String a = "홍길동";
		int b = 100;
		double c = 159.8;
		
		Object[] r = new Object[4];
		r[0] = a;
		r[1] = new Integer(b);
		r[2] = new Double(c);
		r[3] = new Student("1000", "홍길동");
		return r;
	}
}
