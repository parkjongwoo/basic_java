package com.day10.ect;

public class Student {
	String id;
	String name;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+id+"]"+name+"입니다.";
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student))return false;
		Student s = (Student)obj;
		return id.equals(s.id);
	}
	
	
	
}
