package com.day07.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import z_useful.MyException;

public class Ex02_exception_create {

	public static void main(String[] args) {
		String[] msg = {"행복","안녕","멍멍"};
		
		
		try {
			fileLoad();
			readArray();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("MyException:"+e.getMessage());
			//return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally");
		}
		System.out.println("end");
	}
	
	static void fileLoad() {
		FileInputStream fs = null;
		try {
			fs = new FileInputStream("abc.txt");
			fs.read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fs.close();
			} catch (Exception e) {e.printStackTrace();}
		}
	}
	static void readArray() throws MyException {
		String[] msg = {"행복","안녕","멍멍"};
		try {
			for(int i=0;i<5;i++) {
				System.out.println(msg[i]);	
			}
		} catch (Exception e) {
			throw new MyException("내 메세지");
		}
	}

}
