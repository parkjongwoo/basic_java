package com.day09.inherit.q1;

class Parent {

	int i = 7;

	public int get() {
		return i;
	}

}

class Child extends Parent {

	int i = 5;

	public int get() {
		return i;
	}

}

public class Test {

	public static void main(String[] args) {

		Parent p = new Parent();

		System.out.println("---------------------1---------------------");

		System.out.println(p.i);///////// 7

		System.out.println(p.get());/////////// 7

		Child c = new Child();

		System.out.println("---------------------2---------------------");

		System.out.println(c.i);////////// 5

		System.out.println(c.get());/////////// 5

		Parent p2 = new Child();

		System.out.println("---------------------3---------------------");

		System.out.println(p2.i);///////////// 77777777

		System.out.println(p2.get());//////// 5555

	}

}