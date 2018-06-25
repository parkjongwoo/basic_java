package com.day02.operator;

public class Ex10_order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int z = 10 - 7 ^ 3 + 1 * 2 & 4;
		// 3 ^ 5 & 4
		// 3 ^ 4
		// 7
		System.out.println("z:" + z);

		// q1.
		int i = 4, j = 2;
		i = i << j;
		System.out.println("result = " + i);

		// q3.
		// System.out.println( 4 && 7 );

		// q4.
		i = 5;
		System.out.println(i++);
		System.out.println(i++);

		// q5.
		int a = -5;
		if ((a > 0) && ((++a / 3) > 0)) {
			a++;
		}
		System.out.println(a);
	}

}
