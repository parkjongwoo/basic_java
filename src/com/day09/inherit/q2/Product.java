package com.day09.inherit.q2;

import java.util.Scanner;

public abstract class Product {
	
	String[] inputList;
	String[] values;
	StringBuffer sb;
	
	public Product() {
		sb = new StringBuffer();
	}
	
	public String[] getInputList() {
		return inputList;
	}
	
	public String[] getValueList() {
		return values;
	}
	public void showInfo() {
		sb.setLength(0);
		for(int i=0;i<inputList.length;i++) {
			sb.append(inputList[i]).append(">>").append(values[i]).append('\n');
		}
	}
	public void inputInfo(int id, Scanner sc) {
//		Scanner sc = new Scanner(System.in);
		values[0] = String.valueOf(id);
		for(int i=1;i<inputList.length;i++) {
			System.out.println(inputList[i]+">>");
			values[i] = sc.nextLine();
		}
//		if(sc.hasNextLine())
//			sc.nextLine();
//		sc.close();
	}
//	public void showInfo() {
//		for (Field f : getClass().getDeclaredFields()) {
//		    
//		    try {
//		    	String name = f.getName();
//				String value =  f.get(this).toString();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
