package com.day09.inherit.test;

import java.util.Scanner;

public abstract class Product {
	protected String[] keyList;
	protected String[] valueList;
	
	public Product() {}
	
	public void inputData(int index, Scanner sc) {
		valueList[0] = String.valueOf(index);
		for(int i=1;i<keyList.length;i++) {
			System.out.println(keyList[i]+">>");
			valueList[i] = sc.nextLine();
		}
	}
	
	public void showInfo() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<keyList.length;i++) {
			sb.append(keyList[i]).append(">>").append(valueList[i]).append('\n');
		}
		System.out.println(sb);
	}
}
