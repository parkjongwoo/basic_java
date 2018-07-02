package com.day09.inherit;

import java.util.Scanner;

public class BookMainPoly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i = null;
		System.out.println("물품선택->(1.책,2.dvd,3.cd)");
		Scanner in = new Scanner(System.in);
		int sel = in.nextInt();
		switch(sel) {
		case 1:
			i = new Book();
			break;
		case 2:
			i = new Dvd();
			break;
		case 3:
			i = new Cd("5000","트로트","강남");
			break;
		}
		
		i.output();
		in.close();
	}

}
