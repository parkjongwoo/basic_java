package com.day09.inherit;

public class Ddal extends Umma{
	public Ddal() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("자식생성.");
	}
	
	@Override
	public void gene() {
		System.out.println("자식은 자식이다.");
	}
	
	public void study() {
		System.out.println("공부");
	}
}
