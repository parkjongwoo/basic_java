package com.day07.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex01_exception_basic {

	public static void main(String[] args) {
		
		String[] msg = {"행복","안녕","멍멍"};
		
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println(msg[i]);				
			}catch(Exception e) {
				//예외발생시 실행
				e.printStackTrace();
			}finally {
				//반드시 실행
			}
		}
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
			} catch (IOException e) {}
		}
	}

}
