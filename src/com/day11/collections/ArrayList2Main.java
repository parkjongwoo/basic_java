package com.day11.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> list = method();
		for(Student s:list)
			System.out.println(s);
		
		Iterator<Student> i = list.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
	
	static ArrayList<Student> method() {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길자","1000"));
		list.add(new Student("홍길숙","2000"));
		list.add(new Student("홍길동","3000"));
		
		return list;
	}
	
}

class Student{
	String name,id;
	Student(String name, String id){
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+name+":"+id+"]";
	}	
}